package model;

public class Book {
    private String title;
    private String author;
    private int year;
    private boolean isBorrowed;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
        isBorrowed = true;
    }

    public void returnBook() {
        isBorrowed = false;
    }

    public void displayInfo() {
        String status = isBorrowed ? "Dipinjam" : "Tersedia";
        System.out.println(title + " (" + author + ", " + year + ") - " + status);
    }
}
