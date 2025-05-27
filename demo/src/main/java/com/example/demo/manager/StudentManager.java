package com.example.demo.manager;

import com.example.demo.model.Student;

import java.io.*;
import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();
    private final String FILE_NAME = "students.dat";

    public StudentManager() {
        loadFromFile();
    }

    public void addStudent(Student student) {
        students.add(student);
        saveToFile();
    }

    public void updateStudent(String id, Student updated) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                students.set(i, updated);
                saveToFile();
                return;
            }
        }
    }

    public void deleteStudent(String id) {
        students.removeIf(student -> student.getId().equals(id));
        saveToFile();
    }

    public ArrayList<Student> getAll() {
        return students;
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (ArrayList<Student>) ois.readObject();
        } catch (Exception ignored) {
        }
    }
}
