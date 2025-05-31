package com.example;

import com.example.demo.model.Book;
import com.example.demo.model.Student;
import com.example.demo.model.BorrowRecord;
import com.example.demo.manager.GenericManager;


import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        // Khởi tạo các manager
        GenericManager<Book> bookManager = new GenericManager<>("books.dat");
        GenericManager<Student> studentManager = new GenericManager<>("students.dat");
        GenericManager<BorrowRecord> borrowManager = new GenericManager<>("borrow_records.dat");

        // Thêm Book
        Book book1 = new Book("B001", "Java Basics", "Nguyen Van A", "Programming");
        bookManager.add(book1);

        // Thêm Student
        Student student1 = new Student("S001", "Tran Thi B", "tranb@gmail.com");
        studentManager.add(student1);

        // Thêm BorrowRecord
        BorrowRecord record1 = new BorrowRecord("S001", "B001", LocalDate.now());
        borrowManager.add(record1);

        // Hiển thị tất cả sách
        System.out.println("📚 Danh sách sách:");
        for (Book b : bookManager.getAll()) {
            System.out.println(b.getId() + " - " + b.getTitle() + " - " + b.getAuthor());
        }

        // Hiển thị sinh viên
        System.out.println("\n👨‍🎓 Danh sách sinh viên:");
        for (Student s : studentManager.getAll()) {
            System.out.println(s.getId() + " - " + s.getName() + " - " + s.getEmail());
        }

        // Hiển thị mượn sách
        System.out.println("\n📖 Danh sách mượn sách:");
        for (BorrowRecord r : borrowManager.getAll()) {
            System.out.println(r.getStudentId() + " mượn sách " + r.getBookId() + " ngày " + r.getBorrowDate());
        }
    }
}
