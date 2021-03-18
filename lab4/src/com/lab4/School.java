package com.lab4;

public  class School implements Comparable<School> {
    private int capacity;
    private String name;

    public School(int capacity,String name) {
        this.capacity = capacity;
        this.name=name;
    }

    public School(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(School o) {
        return 0;
    }

    @Override
    public String toString() {
        return "School{" +
                "capacity=" + capacity +
                ", name='" + name + '\'' +
                '}';
    }
}
