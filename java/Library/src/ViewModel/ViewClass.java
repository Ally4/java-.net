
package ViewModel;

import DAOBook.DAObook;
import Model.BookModel;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class ViewClass {
    //1.Creating main Function

    /**
     *
     * @param args
     */
    public static void main(String args[]){
           String BookD;
           String BookName;
           String Author;
           String ISBN;
        boolean isRunning=true;
        BookModel bok= new BookModel();
        DAObook dao=new DAObook();
        while(isRunning){
            System.out.println("===========================");
            System.out.println("Library Management System");
            System.out.println("===========================");
            System.out.println("1.Register Book");
            System.out.println("2.Update Book");
            System.out.println("3.Delete Book");
            System.out.println("4.View Book");
            System.out.println("5.Search Book");
            System.out.println("6.Login");
            System.out.println("0.Exit ");
            System.out.print("Enter Your Choice  ");
            Scanner sc=new Scanner(System.in);
            int choice=sc.nextInt();
            switch(choice){
                 case 1:
                     System.out.print("Enter Book ID ");
                     BookD=sc.next();
                     System.out.print("Enter Book Name ");
                     BookName=sc.next();
                     System.out.print("Enter Book Author ");
                     Author=sc.next();
                     System.out.print("Enter Book ISBN ");
                     ISBN=sc.next();
                     bok.setBookD(BookD);
                     bok.setBookName(BookName);
                     bok.setAuthor(Author);
                     bok.setISBN(ISBN);
                     dao.InsertBook(bok);
                     System.out.println("Do You wish to Continue");
                   break;
                case 2:
                    System.out.print("Enter Book ID ");
                     BookD=sc.next();
                     System.out.print("Enter Book Name ");
                     BookName=sc.next();
                     System.out.print("Enter Book Author ");
                     Author=sc.next();
                     System.out.print("Enter Book ISBN ");
                     ISBN=sc.next();
                     bok.setBookD(BookD);
                     bok.setBookName(BookName);
                     bok.setAuthor(Author);
                     bok.setISBN(ISBN);
                     dao.UpdateBook(bok);
                     System.out.println("Do You wish to Continue");
                   break;
                case 3:
                     System.out.print("Enter Book ID ");
                     BookD=sc.next();
                     bok.setBookD(BookD);
                     dao.DeleteBook(bok);
                     System.out.println("Do You wish to Continue");
                   break;
                case 4:
                     dao.ViewchBook(bok);
                   break;   
                case 5:
                    System.out.print("Enter Book ID ");
                     BookD=sc.next();
                     bok.setBookD(BookD);
                     dao.SearchchBook(bok);
                      System.out.println("Do You wish to Continue");
                   break; 
                case 6:
                    System.out.print("Enter Book ID ");
                    BookD=sc.next();
                    System.out.print("Enter Book ISBN ");
                    ISBN=sc.next();
                    bok.setBookD(BookD);
                    bok.setISBN(ISBN);
                    dao.Login(bok);
                     System.out.println("Do You wish to Continue");
                   break;   
                case 0:
                     dao.Exit(bok);
                     System.out.println("Thank you For using Our System");
                     System.exit(0);
                     break;
                 default:
                     System.out.println("Wrong Entry,Try again");
                   isRunning=true;
        }
        }
    }
}
