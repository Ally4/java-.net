using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.Extensions.Configuration;
using System.Data;
using System.Data.SqlClient;

namespace Riddels.Pages
{
    public class LoginModel : PageModel
    {

        public readonly IConfiguration Configuration;
        public LoginModel(IConfiguration configuration)
        {
            Configuration = configuration;
        }
        public users log = new users();

        public string message = "";
        public void OnGet()
        {
        }

        public void OnPost()
        {

            log.Email = Request.Form["email"];
            log.Password = Request.Form["password"];

            if (string.IsNullOrEmpty(log.Email) || string.IsNullOrEmpty(log.Password))
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
                        String qry = "select * from users where email=@email and password=@password";
                        con.Open();
                        using (SqlCommand cmd = new SqlCommand(qry, con))
                        {
                            cmd.Parameters.AddWithValue("@email", log.Email);
                            cmd.Parameters.AddWithValue("@password", log.Password);

                            using (SqlDataReader reader = cmd.ExecuteReader())
                            {
                                if (reader.Read())
                                {
                                    users logs = new users();
                                    logs.Email = reader.GetString(2);
                                    logs.Password = reader.GetString(3);
                                    logs.role = reader.GetString(4);

                                    if (logs.Password.Equals(log.Password))
                                    {
                                        if (logs.role.Equals("Admin"))
                                        {
                                            message = "Welcome Admin";
                                            Response.Redirect("/ Adminpage");
                                        }
                                        else
                                        {
                                            Response.Redirect("/userpage");
                                        }
                                    }
                                    else
                                    {
                                        message = "Email or password is invalid";
                                    }
                                }
                                con.Close();
                            }
                        }
                    }
                }
                catch (Exception ex)
                {
                    message = ex.Message;
                }
               
            }
        }
    }
    public class users
    {
        public String Email { get; set; }
        public String Password { get; set; }
        public String role { get; set; }

    }
}
