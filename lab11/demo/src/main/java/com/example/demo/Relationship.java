package com.example.demo;

public class Relationship {
    private int id;
    private int id1;
    private int id2;

    public Relationship(int id, int id1, int id2) {
        this.id = id;
        this.id1 = id1;
        this.id2 = id2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }
}
