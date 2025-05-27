package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDate;

public class BorrowRecord implements Serializable {
    private String studentId;
    private String bookId;
    private LocalDate borrowDate;

    public BorrowRecord(String studentId, String bookId, LocalDate borrowDate) {
        this.studentId = studentId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
    }

    // Getter
    public String getStudentId() { return studentId; }
    public String getBookId() { return bookId; }
    public LocalDate getBorrowDate() { return borrowDate; }
}
