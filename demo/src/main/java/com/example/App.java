package com.example;

import com.example.demo.model.Book;
import com.example.demo.model.Student;
import com.example.demo.model.BorrowRecord;
import com.example.demo.manager.BookManager;
import com.example.demo.manager.StudentManager;
import com.example.demo.manager.BorrowRecordManager;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        BookManager bookManager = new BookManager();
        StudentManager studentManager = new StudentManager();
        BorrowRecordManager recordManager = new BorrowRecordManager();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Thêm sách");
            System.out.println("2. Hiển thị sách");
            System.out.println("3. Thêm sinh viên");
            System.out.println("4. Hiển thị sinh viên");
            System.out.println("5. Gán sách cho sinh viên");
            System.out.println("6. Hiển thị bản ghi mượn");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("ID sách: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Tên sách: ");
                    String title = scanner.nextLine();
                    System.out.print("Tác giả: ");
                    String author = scanner.nextLine();
                    System.out.print("Thể loại: ");
                    String genre = scanner.nextLine();

                    Book book = new Book(bookId, title, author, genre);
                    bookManager.addBook(book);
                    System.out.println("✅ Đã thêm sách.");
                    break;

                case 2:
                    System.out.println("--- Danh sách sách ---");
                    for (Book b : bookManager.getAll()) {
                        System.out.println(b.getId() + " - " + b.getTitle());
                    }
                    break;

                case 3:
                    System.out.print("ID sinh viên: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Tên sinh viên: ");
                    String name = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    Student student = new Student(studentId, name, email);
                    studentManager.addStudent(student);
                    System.out.println("✅ Đã thêm sinh viên.");
                    break;

                case 4:
                    System.out.println("--- Danh sách sinh viên ---");
                    for (Student s : studentManager.getAll()) {
                        System.out.println(s.getId() + " - " + s.getName());
                    }
                    break;

                case 5:
                    System.out.print("ID sinh viên: ");
                    String sid = scanner.nextLine();
                    System.out.print("ID sách: ");
                    String bid = scanner.nextLine();

                    BorrowRecord record = new BorrowRecord(sid, bid, LocalDate.now());
                    recordManager.addRecord(record);
                    System.out.println("✅ Đã gán sách cho sinh viên.");
                    break;

                case 6:
                    System.out.println("--- Danh sách bản ghi mượn ---");
                    for (BorrowRecord r : recordManager.getAll()) {
                        System.out.println(r.getStudentId() + " mượn sách " + r.getBookId() + " vào ngày " + r.getBorrowDate());
                    }
                    break;
            }

        } while (choice != 0);

        System.out.println("Thoát chương trình.");
        scanner.close();
    }
}
