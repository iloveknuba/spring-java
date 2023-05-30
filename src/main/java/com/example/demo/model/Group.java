package com.example.demo.model;

public class Group {
    private int id;
    private String name;
    private String facultet;
    private int studentsAmount;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFacultet() {
        return facultet;
    }

    public int getStudentsAmount() {
        return studentsAmount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFacultet(String facultet) {
        this.facultet = facultet;
    }

    public void setStudentsAmount(int studentsAmount) {
        this.studentsAmount = studentsAmount;
    }
}
