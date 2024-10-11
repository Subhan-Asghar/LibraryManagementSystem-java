/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.library.management.system;

/**
 *
 * @author lenovo
 */
import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

       
        Book[] library = new Book[100];
        int libraryCount = 0;

       
        Student[] students = new Student[100];
        int studentCount = 0;

        while (true) {
            System.out.println("--- Library Management System ---");
            System.out.println("1. Add a new book");
            System.out.println("2. Add a new student");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. Show all books borrowed and returned by a student");
            System.out.println("6. Exit");
            System.out.println("-------------------------------------------------------");
            System.out.print("Choose an option: ");
            int option = input.nextInt();
            input.nextLine(); 
            System.out.println("-------------------------------------------------------");
            boolean studentFound = false;

            if (option==1) {
                
                    System.out.print("Enter book title: ");
                    String title = input.nextLine();
                    System.out.print("Enter author: ");
                    String author = input.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = input.nextInt();
                    input.nextLine();  

                   
                        
                        library[libraryCount] = new Book(title, author, quantity);
                        libraryCount++;
                        System.out.println("Book added successfully!");
                    
                  
                    
            }

            else if(option==2){
                    System.out.print("Enter student name: ");
                    String studentName = input.nextLine();
                    boolean exist=false;
                    for(int i=0;i<studentCount;i++){
                        if(students[i].getName().equals(studentName)){
                            System.out.println("Student is already exist");
                            exist=true;
                        }
                       
                    }
                     if(!exist){
                         students[studentCount] = new Student(studentName);
                        studentCount++;
                        System.out.println("Student added successfully!");
                        
                        }
                      
                   
            }

            else if(option==3){
                    System.out.print("Enter student name: ");
                    String borrowerName = input.nextLine();
                 
                    for (int i = 0; i < studentCount; i++) {
                        
                        if (students[i].getName().equals(borrowerName)) {
                            
                            studentFound = true;

                            System.out.print("Enter the title of the book to borrow: ");
                            String borrowTitle = input.nextLine();
                            boolean bookFound = false;
                            
                            for (int j = 0; j < libraryCount; j++) {
                                if (library[j].getBookTitle().equals(borrowTitle)) {
                                    bookFound = true;
                                    if (library[j].isAvailable()) {
                                        
                                        students[i].borrowBook(library[j]);
                                    } 
                                    else {
                                        System.out.println("Book is not available for borrowing.");
                                        
                                    }
                                    break;
                                }
                            }
                            if (!bookFound) {
                                System.out.println("Book not found in the library.");
                            }
                            break;
                        }
                    }
                    if (!studentFound) {
                        System.out.println("Student not found.");
                    }
            }

            else if(option==4){
                    System.out.print("Enter student name: ");
                    String returnerName = input.nextLine();
                    studentFound = false;
                    for (int i = 0; i < studentCount; i++) {
                        
                        if (students[i].getName().equals(returnerName))
                        {
                            studentFound = true;

                            System.out.print("Enter the title of the book to return: ");
                            String returnTitle = input.nextLine();
                            boolean bookFound = false;
                            for (int j = 0; j < libraryCount; j++) {
                                if (library[j].getBookTitle().equals(returnTitle)) {
                                    bookFound = true;
                                    students[i].returnBook(library[j]);
                                    break;
                                }
                            }
                            if (!bookFound) {
                                System.out.println("Book not found in the library.");
                            }
                            break;
                        }
                    }
                    if (!studentFound) {
                        System.out.println("Student not found.");
                    }
            }

            else if(option==5){
                    System.out.print("Enter student name: ");
                    String showName = input.nextLine();
                    studentFound = false;
                    for (int i = 0; i < studentCount; i++) {
                        if (students[i].getName().equals(showName)) {
                            studentFound = true;
                            students[i].showBooks();
                            break;
                        }
                    }
                    if (!studentFound) {
                        System.out.println("Student not found.");
                    }
            }

            else if(option==6){
                    System.out.println("Exiting the system. Goodbye!");
                    return;
            }

            else{
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
