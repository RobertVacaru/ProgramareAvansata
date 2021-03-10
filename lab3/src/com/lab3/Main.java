package com.lab3;

import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        Hotel hotel;
        hotel = new Hotel("h1",new Rank(1));

        Museum museum1=new Museum("m1");
        museum1.setOpeningTime(LocalTime.of(8,0));
        museum1.setClosingTime(LocalTime.of(16,0));
        museum1.setTicketPrice(2.5);
        Museum museum2=new Museum("m2");
        museum1.setOpeningTime(LocalTime.of(9,0));
        museum1.setClosingTime(LocalTime.of(17,0));
        museum1.setTicketPrice(3.0);
        Church church1=new Church("c1", LocalTime.of(8,0),LocalTime.of(18,0));
        Church church2=new Church("c2",LocalTime.of(7,30),LocalTime.of(17,0));
        Restaurant restaurant=new Restaurant("r1",new Rank(1));
        //from-to -> cost
        hotel.setCost(museum1,10);
        hotel.setCost(museum2,50);
        museum1.setCost(museum2,20);
        museum1.setCost(church1,20);
        museum1.setCost(church2,10);
        museum2.setCost(museum1,20);
        museum2.setCost(church1,20);
        church1.setCost(church2,30);
        church2.setCost(church1,30);
        church1.setCost(restaurant,10);
        church2.setCost(restaurant,20);
        //adding locations in city
        City city =new City();
        city.addLocation(hotel);
        city.addLocation(museum1);
        city.addLocation(museum2);
        city.addLocation(church1);
        city.addLocation(church2);
        city.addLocation(restaurant);


        //set by default(from optional)
        church1.setdefaultOpenhour();
        church1.setdefaultClosehour();

        System.out.println(museum1);
        System.out.println(church1);
        System.out.println(hotel);

        City Iasi=new City();
        Iasi.addLocation(museum1);
        Iasi.addLocation(church1);
        Iasi.displayLocations();

        System.out.println("\nDuration between opening hour and closing hour in aspecific location:");
        System.out.println(Visitable.getVisitingDuration(church1));
    }
}
