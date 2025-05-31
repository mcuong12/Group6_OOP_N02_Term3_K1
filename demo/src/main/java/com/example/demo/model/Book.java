package com.example.demo.model;

import com.example.demo.common.Identifiable;
import java.io.Serializable;

public class Book implements Serializable, Identifiable {
    private String id;
    private String title;
    private String author;
    private String genre;

    public Book(String id, String title, String author, String genre){
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public String getId() { return id; }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
}
