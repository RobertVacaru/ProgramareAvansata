package com.lab3;

import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.*;

public class Church extends Location implements Visitable {
    private LocalTime openingTime, closingTime;

    public Church(String name, LocalTime openingTime, LocalTime closingTime) {
        super(name);
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }
    @Override
    public void setdefaultOpenhour()
    {
        this.openingTime=LocalTime.of(9,30);
    }
    @Override
    public void setdefaultClosehour()
    {
        this.closingTime=LocalTime.of(20,0);
    }

    @Override
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }

    /*public void getDuration(){
        System.out.println(openingTime.until(closingTime,HOURS));
        System.out.println(openingTime.until(closingTime,MINUTES));
        System.out.println(openingTime.until(closingTime,SECONDS));

    }*/
    @Override
    public String toString() {
        return "Church{" +
                "openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                '}';
    }
}