package com.lab_2;

public class Factory extends Source{
    private String name;

    public Factory() {
    }

    public Factory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Factory{" +
                "nume='" + name + '\'' +
                '}';
    }
}
