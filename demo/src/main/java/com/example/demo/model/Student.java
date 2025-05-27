package com.example.demo.model;

import java.io.Serializable;

public class Student implements Serializable {
    private String id;
    private String name;
    private String email;

    public Student(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getter
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}
