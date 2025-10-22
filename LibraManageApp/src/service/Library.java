package service;

import model.Book;
import model.User;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book b) {
        books.add(b);
        System.out.println("Buku \"" + b.getTitle() + "\" berhasil ditambahkan.");
    }

    public void showAllBooks() {
        System.out.println("===== DAFTAR BUKU =====");
        if (books.isEmpty()) {
            System.out.println("Belum ada buku di perpustakaan.");
        } else {
            for (Book b : books) {
                b.displayInfo();
            }
        }
    }

    public void borrowBook(String userName, String title) {
        User user = findOrCreateUser(userName);
        Book book = findBook(title);

        if (book == null) {
            System.out.println("Buku tidak ditemukan.");
            return;
        }

        if (book.isBorrowed()) {
            System.out.println("Buku tersebut sedang dipinjam orang lain.");
            return;
        }

        book.borrowBook();
        user.borrowBook(book);
        System.out.println("Buku \"" + title + "\" berhasil dipinjam oleh " + userName + ".");
    }

    public void returnBook(String userName, String title) {
        User user = findUser(userName);
        Book book = findBook(title);

        if (user == null || book == null) {
            System.out.println("Data peminjam atau buku tidak ditemukan.");
            return;
        }

        if (!book.isBorrowed()) {
            System.out.println("Buku tersebut belum dipinjam.");
            return;
        }

        book.returnBook();
        user.returnBook(book);
        System.out.println("Buku \"" + title + "\" telah dikembalikan oleh " + userName + ".");
    }

    public void showBorrowedBooks() {
        System.out.println("===== DAFTAR BUKU DIPINJAM =====");
        boolean ada = false;
        for (User u : users) {
            for (Book b : new ArrayList<>(u.getBorrowedBooks())) {
                if (b.isBorrowed()) {
                    System.out.println(b.getTitle() + " - Dipinjam oleh " + u.getName());
                    ada = true;
                }
            }
        }
        if (!ada) {
            System.out.println("Tidak ada buku yang sedang dipinjam.");
        }
    }

    private User findUser(String name) {
        for (User u : users) {
            if (u.getName().equalsIgnoreCase(name)) {
                return u;
            }
        }
        return null;
    }

    private User findOrCreateUser(String name) {
        User u = findUser(name);
        if (u == null) {
            u = new User(name);
            users.add(u);
        }
        return u;
    }

    private Book findBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }
}
