using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.Extensions.Configuration;
using System.Data.SqlClient;


namespace Riddels.Pages.RR
{

    public class EditRiddleModel : PageModel
    {
        public riddel riddleInfo = new riddel();
        public string erroMessage { get; set; }
        public EditRiddleModel(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        public void OnGet()
        {
            string id = Request.Query["id"];
            string? conn = Configuration.GetConnectionString("con");
            try
            {
                using (SqlConnection con = new SqlConnection(conn))
                {
                    con.Open();
                    string sqlQry = "SELECT *FROM riddle  WHERE id=@id";
                    using (SqlCommand cmd = new SqlCommand(sqlQry, con))
                    {
                        cmd.Parameters.AddWithValue("@id", id);
                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            if (reader.Read())
                            {
                                riddleInfo.riddel_id = reader.GetString(0);
                                riddleInfo.riddel_name = reader.GetString(1);
                            }
                        }

                    }
                }

            }
            catch (Exception ex)
            {
                erroMessage = ex.Message;
            }

        }
        public void OnPost()
        {
            riddleInfo.riddel_id = Request.Form["id"];
            riddleInfo.riddel_name = Request.Form["name"];
            string? conn = Configuration.GetConnectionString("con");
            try
            {
                using (SqlConnection con = new SqlConnection(conn))
                {
                    con.Open();
                    string sqlQuerry = "UPDATE riddle SET name=@name WHERE id=@id";
                    using (SqlCommand cmd = new SqlCommand(sqlQuerry, con))
                    {
                        cmd.Parameters.AddWithValue("@id", riddleInfo.riddel_id);
                        cmd.Parameters.AddWithValue("@name", riddleInfo.riddel_name);


                        cmd.ExecuteNonQuery();
                    }

                }
            }
            catch (Exception ex)
            {
                erroMessage = ex.Message;
            }
            Response.Redirect("/riddelss");
        }
    }
}
