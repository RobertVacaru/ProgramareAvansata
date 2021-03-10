package com.lab3;

import java.util.HashMap;
import java.util.Map;

public abstract class Location implements Comparable<Location>
{
    private String name;
    private Map<Location, Integer> cost ;

    public Location() {
    }

    public Location(String name) {
        this.name = name;
        cost=new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer  getCost(Location location) {
        return cost.get(location);
    }

    public void setCost(Location node, int value) {
        cost.put(node, value);
    }

    @Override
    public int compareTo(Location other) {
        return this.name.compareTo(other.name);
        //not safe, check if name is null before
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
