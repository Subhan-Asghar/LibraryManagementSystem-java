/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library.management.system;

/**
 *
 * @author lenovo
 */
public class Book {
     private String Title;
    private String Author;
    private int quantity;
    
    public Book(){
        Title = "abc";
        Author = "xyz";
        quantity = 0;
    }

    public Book(String Title, String Author, int quantity) {
        this.Title = Title;
        this.Author = Author;
        this.quantity = quantity;
    }

    
    public String getBookTitle() {
        return this.Title;
    }

    public String getBookAuthor() {
        return this.Author;
    }

    public int getquantity() {
        return this.quantity;
    }

    public void setquantity(int quantity) {
        this.quantity = quantity;
    }
      public void setBookTitle(String title) {
        this.Title=title;
    }
         public void setBookAuthor(String author) {
        this.Author=author;
    }

    // Check if the book is available to borrow
    public boolean isAvailable() {
        boolean check=this.quantity > 0;
        return check;
    }

    // Borrow a book
    public void borrowBook() {
        if (this.quantity>0) {
            this.quantity--;
        } else {
            System.out.println("Sorry, this book is not available right now.");
        }
    }

    // Return a book
    public void returnBook() {
        this.quantity++;
    }
}
