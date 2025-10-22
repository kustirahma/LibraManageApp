package main;

import model.Book;
import service.Library;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n====================================");
            System.out.println("  SISTEM MANAJEMEN PERPUSTAKAAN");
            System.out.println("           LibraManageApp");
            System.out.println("====================================");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Lihat Daftar Buku");
            System.out.println("3. Pinjam Buku");
            System.out.println("4. Kembalikan Buku");
            System.out.println("5. Lihat Buku Dipinjam");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Judul Buku: ");
                    String title = input.nextLine();
                    System.out.print("Penulis: ");
                    String author = input.nextLine();
                    System.out.print("Tahun Terbit: ");
                    int year = input.nextInt();
                    input.nextLine();
                    library.addBook(new Book(title, author, year));
                    break;

                case 2:
                    library.showAllBooks();
                    break;

                case 3:
                    System.out.print("Nama Peminjam: ");
                    String userName = input.nextLine();
                    System.out.print("Judul Buku: ");
                    String borrowTitle = input.nextLine();
                    library.borrowBook(userName, borrowTitle);
                    break;

                case 4:
                    System.out.print("Nama Peminjam: ");
                    String returnName = input.nextLine();
                    System.out.print("Judul Buku: ");
                    String returnTitle = input.nextLine();
                    library.returnBook(returnName, returnTitle);
                    break;

                case 5:
                    library.showBorrowedBooks();
                    break;

                case 0:
                    System.out.println("Terima kasih telah menggunakan LibraManageApp!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (choice != 0);

        input.close();
    }
}
