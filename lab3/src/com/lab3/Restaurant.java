package com.lab3;

public class Restaurant extends Location implements Classifiable{
    private Rank rank;


    public Restaurant(String name, Rank rank) {
        super(name);
        this.rank = rank;
    }

    @Override
    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "rank=" + rank +
                '}';
    }
}
