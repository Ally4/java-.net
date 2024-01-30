/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOBook;

import Model.BookModel;
import java.sql.*;
public class DAObook {
    //Declaration Of Global Variable
    private  String url="jdbc:mysql://localhost:3306/Java";
    private String user="root";
    private String pass="Mugabe@@96";
    // we need Constructor
    public DAObook(){
        
    }
    //CRUDE Operation
     public String InsertBook(BookModel BookModel) {
         
         try{
             Connection con=DriverManager.getConnection(url, user, pass);
             String sql="insert into Book1(BookD,BookName,Author,ISBN)values(?,?,?,?);";
             PreparedStatement ps=con.prepareStatement(sql);
             ps.setString(1, BookModel.getBookD());
             ps.setString(2,BookModel.getBookName());
             ps.setString(3,BookModel.getAuthor());
             ps.setString(4, BookModel.getISBN());
             int result=ps.executeUpdate();
             if(result>=0){
                 System.out.println("Succesful Registered");
             }else{
                 System.out.println("Registration Failed");
             }
            
             con.close();
         }catch(Exception e){
             System.out.println("Server Erroe");
             e.printStackTrace();
         }
        return "";
     }
     //CRUDE UPDATE OPERATION
     public String UpdateBook(BookModel BookModel) {
         
         try{
             Connection con=DriverManager.getConnection(url, user, pass);
             String sql="UPDATE  Book1 SET BookName=?, Author=? , ISBN=? WHERE BookD=?;";
             PreparedStatement ps=con.prepareStatement(sql);
             ps.setString(1,BookModel.getBookName());
             ps.setString(2,BookModel.getAuthor());
             ps.setString(3,BookModel.getISBN());
             ps.setString(4,BookModel.getBookD());
             int result=ps.executeUpdate();
             if(result>=0){
                 System.out.println("Succesful Updated");
             }else{
                 System.out.println("Update Failed");
             }
            
             con.close();
         }catch(Exception e){
             System.out.println("Server Erroe");
             e.printStackTrace();
         }
        return "";
     }
     //3.Delete Book Function
     public String DeleteBook(BookModel BookModel) {
         
         try{
             Connection con=DriverManager.getConnection(url, user, pass);
             String sql="DELETE FROM Book1  WHERE BookD=?;";
             PreparedStatement ps=con.prepareStatement(sql);
//             ps.setString(1,BookModel.getBookName());
//             ps.setString(2,BookModel.getAuthor());
//             ps.setString(3,BookModel.getISBN());
             ps.setString(1,BookModel.getBookD());
             int result=ps.executeUpdate();
             if(result>=0){
                 System.out.println("Succesful Deleted");
             }else{
                 System.out.println("Deletion Failed");
             }
            
             con.close();
         }catch(Exception e){
             System.out.println("Server Erroe");
             e.printStackTrace();
         }
        return "";
     }
     //4.Dispaly All Book Method
     public String ViewchBook(BookModel BookModel) {
         
         try{
             Connection con=DriverManager.getConnection(url, user, pass);
             String sql="select * FROM Book1;";
             PreparedStatement ps=con.prepareStatement(sql);
             ResultSet rs=ps.executeQuery();
             String result;
             int count=1;
            while(rs.next()){
                System.out.println("Record "+count);
                System.out.println("=======");
                System.out.println("BookID "+"BookName "+ " Author "+" ISBN");
                result=rs.getInt(1)+"      "     +     rs.getString(2)   +  "     " +rs.getString(3)  +  "   " +  rs.getString(4);
                System.out.println(result);
                count++;
            }
             con.close();
         }catch(Exception e){
             System.out.println("Server Erroe");
             e.printStackTrace();
         }
        return "";
     }
     //5.Search Book Function
     
        public String SearchchBook(BookModel BookModel) {
         
         try{
             Connection con=DriverManager.getConnection(url, user, pass);
             String sql="select * FROM Book1 WHERE BookD=?;";
             PreparedStatement ps=con.prepareStatement(sql);
             ps.setString(1, BookModel.getBookD());
             ResultSet rs=ps.executeQuery();
             String result;
             int count=1;
            while(rs.next()){
                System.out.println("Record "+count);
                System.out.println("=======");
                System.out.println("BookID "+"BookName "+ " Author "+" ISBN");
                result=rs.getInt(1)+"      "     +     rs.getString(2)   +  "     " +rs.getString(3)  +  "   " +  rs.getString(4);
                System.out.println(result);
                count++;
            }
             con.close();
         }catch(Exception e){
             System.out.println("Server Error");
             e.printStackTrace();
         }
        return "";
     }
      //6.Exit Function
          public String Exit(BookModel BookModel) {
              
            return"";
          
          }
       //7.Login Function
         
       public String Login(BookModel BookModel) {
         
         try{
             Connection con=DriverManager.getConnection(url, user, pass);
             String sql="select * FROM Book1 WHERE BookD=? && ISBN=?;";
             PreparedStatement ps=con.prepareStatement(sql);
             ps.setString(2,BookModel.getISBN());
             ps.setString(1,BookModel.getBookD());
             ResultSet rs=ps.executeQuery();
             String result;
             int count=1;
            while(rs.next()){
               
           
                System.out.println("Record "+count);
                System.out.println("=======");
                System.out.println("BookID " + " ISBN");
                result=rs.getInt(1)+"      "     +     rs.getString(2) ;
                System.out.println(result);
                 
             }
             con.close();
            
            
         }catch(Exception e){
             System.out.println("Server Error");
             e.printStackTrace();
         }
        return "";
     }
    } 
  
     
 