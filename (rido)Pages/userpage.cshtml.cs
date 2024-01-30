using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using System.Data.SqlClient;

namespace Riddels.Pages
{
    public class userpageModel : PageModel
    {
        public readonly IConfiguration Configuration;
        public userpageModel(IConfiguration configuration)
        {
            Configuration = configuration;
        }
        public List<questionM> Questions { get; set; }
        public questionM qsti = new questionM();
        public string ErrorMessage { get; set; }
        public int CurrentQuestionIndex;
        public void OnGet()
        {
            GetQuestionsFromDb();
        }
        public int user_id=1;
        public int question_id;
        public int ans;
        public int inputsata;
        public int score =0;
        public int dddd;
        public  void OnPost()
        {
           
            OnGet();
            inputsata = Int32.Parse(Request.Form["answer"]);
            ans =Int32.Parse( Request.Form["user"]);
            question_id = Int32.Parse(Request.Form["questionIDD"]);
            if (inputsata==ans)
            {
                
                    score += 10;
              
            }
            else if (inputsata == ans)
            {
                    score += 10;
                
            }
            else if (inputsata == ans)
            {
               
                    score += 10;
                
            }
            else
            {
                ErrorMessage = "Select your answer!!";
            }

            ErrorMessage = ""+score;
            //////////////////////////////////Inserting data//////////////////////////////////////////////////////
            String? conn = Configuration.GetConnectionString("con");
            try
            {
                using (SqlConnection con = new SqlConnection(conn))
                {
                    String qry = "insert into report values (@user_id,@question_id,@marks)";
                    con.Open();

                    using (SqlCommand cmd = new SqlCommand(qry, con))
                    {
                        cmd.Parameters.AddWithValue("@user_id", user_id);
                        cmd.Parameters.AddWithValue("@question_id", question_id);
                        cmd.Parameters.AddWithValue("@marks", score);

                        score = 0;
                        int rowsAffected = cmd.ExecuteNonQuery();
                        if (rowsAffected > 0)
                        {
                            ErrorMessage = "Byakunze";
                        }
                        else
                        {
                            ErrorMessage = "Byanze";
                        }
                    }
                    con.Close();
                }
            }
            catch (Exception ex)
            {
                ErrorMessage= ex.Message;
            }
            

        }

        public IActionResult OnPostNextQuestion()
        {
            //dddd = Questions.Count;
            
            //CurrentQuestionIndex++;
            if (Questions != null && Questions.Count > CurrentQuestionIndex)
            {
                CurrentQuestionIndex++;
                GetQuestionsFromDb();
                return Page();
            }
            else
            {
                    return RedirectToPage("/SummaryPage");
                
            }
        }
        /// ///////////////////////////////////
        //public void OnPostNextQuestion()
        //{
        //    GetQuestionsFromDb();
        //    if (Questions != null) {
        //        for (CurrentQuestionIndex = 1; CurrentQuestionIndex <= Questions.Count; CurrentQuestionIndex++)
        //        {
        //            Page();
        //        }
        //    }
        //    else
        //    {
        //      Response.Redirect("/SummaryPage");
        //    }

        //}




        public void pathdata()
        {
            Response.Redirect("/SummaryPage");
        }

        private void GetQuestionsFromDb()
        {
            try        
            {
                string connectionString = Configuration.GetConnectionString("con");

                using (SqlConnection connection = new SqlConnection(connectionString))
                {
                    connection.Open();

                    string query = "SELECT * FROM questions";
                    using (SqlCommand command = new SqlCommand(query, connection))
                    {
                        using (SqlDataReader reader = command.ExecuteReader())
                        {
                            Questions = new List<questionM>();

                            while (reader.Read())
                            {

                                {
                                    questionM qst = new questionM();
                                    //Questions.Add(question);
                                    qst.id = reader.GetInt32(reader.GetOrdinal("id"));
                                    //qst.rid_id = reader.GetString(reader.GetOrdinal("rid"));
                                    qst.qst = reader.GetString(reader.GetOrdinal("question"));
                                    qst.opt1 = reader.GetString(reader.GetOrdinal("option_1"));
                                    qst.opt2 = reader.GetString(reader.GetOrdinal("option_2"));
                                    qst.opt3 = reader.GetString(reader.GetOrdinal("option_3"));
                                    qst.correct = reader.GetInt32(reader.GetOrdinal("correct_answer"));
                                    Questions.Add(qst);
                                };


                            }
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                ErrorMessage = ex.Message;
            }
        }
    }
    public class questionM
    {
        public int? id { get; set; }
        public string? rid_id { get; set; }
        public string? qst { get; set; }
        public string? opt1 { get; set; }
        public string? opt2 { get; set; }
        public string? opt3 { get; set; }
        public int? correct { get; set; }

    }
}
