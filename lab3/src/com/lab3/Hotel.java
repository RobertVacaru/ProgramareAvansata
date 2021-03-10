package com.lab3;

public class Hotel extends Location implements Classifiable{
   private Rank rank;

    public Hotel(String name,Rank rank) {
        super(name);
        this.rank=rank;
    }

    @Override
    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

}
