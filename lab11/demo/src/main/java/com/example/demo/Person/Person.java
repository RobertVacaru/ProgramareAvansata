package com.example.demo.Person;

public class Person {
    private String name;
    private int id;
    private int friends;

    public Person() {
    }

    public Person(String name, int id, int friends) {
        this.name = name;
        this.id = id;
        this.friends = friends;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFriends() {
        return friends;
    }

    public void setFriends(int friends) {
        this.friends = friends;
    }
}
