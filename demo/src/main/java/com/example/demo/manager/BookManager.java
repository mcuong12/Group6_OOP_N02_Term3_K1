package com.example.demo.manager;

import com.example.demo.model.Book;

import java.io.*;
import java.util.ArrayList;

public class BookManager {
    private ArrayList<Book> books = new ArrayList<>();
    private final String FILE_NAME = "books.dat";

    public BookManager() {
        loadFromFile();
    }

    public void addBook(Book book) {
        books.add(book);
        saveToFile();
    }

    public void updateBook(String id, Book updated) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId().equals(id)) {
                books.set(i, updated);
                saveToFile();
                return;
            }
        }
    }

    public void deleteBook(String id) {
        books.removeIf(book -> book.getId().equals(id));
        saveToFile();
    }

    public ArrayList<Book> getAll() {
        return books;
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            books = (ArrayList<Book>) ois.readObject();
        } catch (Exception ignored) {
        }
    }
}
