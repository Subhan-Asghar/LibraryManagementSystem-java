/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library.management.system;

/**
 *
 * @author lenovo
 */
import java.util.Date;
import java.text.SimpleDateFormat;

public class Student {

    private String name;
    private String[] books;
    private String[] borrowDates;
    private String[] returnDates;
    private int bookCount;

    public Student() {
        this.name = "abc";
        books = new String[100];
        borrowDates = new String[100];
        returnDates = new String[100];
        bookCount = 0;
    }

    public Student(String name) {
        this.name = name;
        books = new String[100];
        borrowDates = new String[100];
        returnDates = new String[100];
        bookCount = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    // Borrow a book
    public void borrowBook(Book lib) {
        if (!(lib.isAvailable())) {
            System.out.println("Sorry, " + lib.getBookTitle() + " is not available or you have borrowed too many books.");

        } else {
            lib.borrowBook();
            books[bookCount] = lib.getBookTitle();
            borrowDates[bookCount] = currentDate();
            returnDates[bookCount] = "Not returned yet";
            System.out.println(name + " borrowed the book: " + lib.getBookTitle() + " on " + currentDate());
            bookCount++;

        }
    }

    // Return a book
    public void returnBook(Book lib) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].equals(lib.getBookTitle())) {
                lib.returnBook();
                returnDates[i] = currentDate();
                System.out.println(name + " returned the book: " + lib.getBookTitle() + " on " + returnDates[i]);
                return;
            }
        }
        System.out.println("You don't have the book: " + lib.getBookTitle());
    }

    
    public void showBooks() {
        System.out.println("Student: " + name);
        for (int i = 0; i < bookCount; i++) {

            System.out.println("Book: " + books[i] + " | Borrowed on: " + borrowDates[i] + " | Returned on: " + returnDates[i]);

        }
    }

    // Get the current date
    private String currentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return formatter.format(date);
    }
}
