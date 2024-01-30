using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.Extensions.Configuration;
using System.Data.SqlClient;
using System.Data;

namespace Riddels.Pages
{
    public class riddelssModel : PageModel
    {
        public readonly IConfiguration Configuration;
        public List<riddle> riddlelist = new List<riddle>();
        public String Message;
        public riddelssModel(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public riddel riddel = new riddel();
        public string message = "";
        public void OnGet()
        {
            GetRiddlesFromDb();
        }

        public void OnPost()
        {
            riddel.riddel_name = Request.Form["id"].ToString();
            riddel.riddel_id = Request.Form["name"].ToString();


            if (string.IsNullOrEmpty(riddel.riddel_name) || string.IsNullOrEmpty(riddel.riddel_id))
            {
                message = "all fields are required";
            }

            else
            {
                String? conn = Configuration.GetConnectionString("con");
                try
                {
                    using (SqlConnection con = new SqlConnection(conn))
                    {
                        String qry = "insert into riddle values (@riddel_id, @riddel_name)";
                        con.Open();

                        using (SqlCommand cmd = new SqlCommand(qry, con))
                        {
                            cmd.Parameters.AddWithValue("@riddel_name", riddel.riddel_name);
                            cmd.Parameters.AddWithValue("@riddel_id",  riddel.riddel_id);


                            int rowsAffected = cmd.ExecuteNonQuery();
                            if (rowsAffected > 0)
                            {
                                message = "welcome";
                            }
                            else
                            {
                                message = "something went wrong";
                            }
                        }
                        con.Close();
                    }
                }
                catch (Exception ex)
                {
                    message = ex.Message;
                }
            }
        }

        private void GetRiddlesFromDb()
        {
            try
            {
                string connectionString = Configuration.GetConnectionString("con");

                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                    connection.Open();

                    string query = "SELECT * FROM riddle";
                    using (SqlCommand command = new SqlCommand(query, connection))
                    {
                        using (SqlDataReader reader = command.ExecuteReader())
                        {
                            while (reader.Read())
                            {

                                {
                                    riddle r = new riddle();
                                    r.riddel_id = reader.GetString(reader.GetOrdinal("id"));
                                    r.riddel_name = reader.GetString(reader.GetOrdinal("name"));
                                    riddlelist.Add(r);
                                };

                            }
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                Message = ex.Message;
            }
        }
    }

   
   
}


public class riddel
    {
        public int id { get; set; }
        public string UserName { get; set; }
        public string riddel_name { get; set; }
        public string riddel_id { get; set; }

    }

