/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;

public class BookModel {
    // Model class with Private Variable and Constructor
    //1.Create private variable
    private String BookD;
    private String BookName;
    private String Author;
    private String ISBN;
    //2.Ceating Setter and getter Method

    public String getBookD() {
        return BookD;
    }

    public void setBookD(String BookD) {
        this.BookD = BookD;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
}
