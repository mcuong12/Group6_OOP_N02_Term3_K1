package com.example.demo.manager;

import com.example.demo.model.BorrowRecord;

import java.io.*;
import java.util.ArrayList;

public class BorrowRecordManager {
    private ArrayList<BorrowRecord> records = new ArrayList<>();
    private final String FILE_NAME = "borrow_records.dat";

    public BorrowRecordManager() {
        loadFromFile();
    }

    public void addRecord(BorrowRecord record) {
        records.add(record);
        saveToFile();
    }

    public void deleteRecord(String studentId, String bookId) {
        records.removeIf(r -> r.getStudentId().equals(studentId) && r.getBookId().equals(bookId));
        saveToFile();
    }

    public ArrayList<BorrowRecord> getAll() {
        return records;
    }

    public ArrayList<BorrowRecord> getByStudent(String studentId) {
        ArrayList<BorrowRecord> result = new ArrayList<>();
        for (BorrowRecord r : records) {
            if (r.getStudentId().equals(studentId)) {
                result.add(r);
            }
        }
        return result;
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(records);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            records = (ArrayList<BorrowRecord>) ois.readObject();
        } catch (Exception ignored) {
        }
    }
}
