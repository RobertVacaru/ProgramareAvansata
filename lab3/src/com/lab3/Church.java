package com.lab3;

import java.time.LocalTime;

public class Church extends Location implements Visitable {
    private LocalTime openingTime, closingTime;

    public Church(String name, LocalTime openingTime, LocalTime closingTime) {
        super(name);
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }


    @Override
    public LocalTime getOpeningTime() {
        return null;
    }

    @Override
    public LocalTime getClosingTime() {
        return null;
    }

    @Override
    public String toString() {
        return "Church{" +
                "openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                '}';
    }
}