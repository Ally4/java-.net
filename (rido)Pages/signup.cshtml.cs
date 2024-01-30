using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.Extensions.Primitives;
using System.Data;
using System.Data.SqlClient;

namespace Riddels.Pages
{
    public class signupModel : PageModel
    {
        public readonly IConfiguration Configuration;
        public signupModel(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public user Users = new user();
        public string message = "";
        public void OnGet()
        {
        }
        public void OnPost() 
        {
            Users.UserName = Request.Form["username"];
            Users.Email = Request.Form["email"];
            Users.Password = Request.Form["password"];


            if (string.IsNullOrEmpty(Users.UserName) || string.IsNullOrEmpty(Users.Email) || string.IsNullOrEmpty(Users.Password))
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
                        String qry = "insert into users values (@username, @email, @password, 'user')";
                        con.Open();

                        using (SqlCommand cmd = new SqlCommand(qry, con))
                        {

                            cmd.Parameters.Add("@username", SqlDbType.NVarChar, 255).Value = Users.UserName;
                            cmd.Parameters.Add("@email", SqlDbType.NVarChar, 255).Value = Users.Email;
                            cmd.Parameters.Add("@password", SqlDbType.NVarChar, 255).Value = Users.Password;


                            int rowsAffected = cmd.ExecuteNonQuery();
                            if (rowsAffected > 0)
                            {
                                message = "Account created successfuly!!";
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
    }
    public class user
    {
        internal StringValues riddel_name;
        internal StringValues riddel_id;

        public int id { get; set; }
        public string UserName { get; set;}
        public string Email {  get; set;}
        public string Password { get; set;}

    }
}
