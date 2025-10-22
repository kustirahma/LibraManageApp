package model;

import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<Book> borrowedBooks;

    public User(String name) {
        this.name = name;
        this.setBorrowedBooks(new ArrayList<>());
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
        
    }

    public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
        
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book) {
        getBorrowedBooks().add(book);
    }

    public void returnBook(Book book) {
        getBorrowedBooks().remove(book);
    }

    public void displayBorrowedBooks() {
        System.out.println("Buku yang dipinjam oleh " + name + ":");
        if (getBorrowedBooks().isEmpty()) {
            System.out.println("- Tidak ada buku yang dipinjam");
        } else {
            for (Book b : getBorrowedBooks()) {
                System.out.println("- " + b.getTitle());
            }
        }
    }
}
