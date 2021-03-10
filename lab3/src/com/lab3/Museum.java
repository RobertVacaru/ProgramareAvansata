package com.lab3;

import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.*;

public class Museum extends Location implements Visitable,Payable{
    private LocalTime openingTime, closingTime;
    private double ticketPrice;

    public Museum(String name) {
        super(name);
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
    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }
    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }
    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }
    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    public void getVissitingDuration(){
        System.out.println(openingTime.until(closingTime,HOURS));
        System.out.println(openingTime.until(closingTime,MINUTES));
        System.out.println(openingTime.until(closingTime,SECONDS));

    }
    @Override
    public String toString() {
        return "Museum{" +
                "openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}