package com.lab_2;

import java.util.Objects;

public class Source {

    public String name;
    private SourceType type;

    public Source() {
    }
    public Source(String name, SourceType type) {
        this.name = name;
        this.type = type;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SourceType getType() {
        return type;
    }

    public void setType(SourceType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return Objects.equals(name, source.name);
    }

    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}