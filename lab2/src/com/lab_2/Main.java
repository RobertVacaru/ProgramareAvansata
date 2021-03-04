package com.lab_2;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Problem pb = new Problem();
        int supply[] = {10, 35, 25};
        pb.setSupply(supply);
        int demand[] = {20, 25, 25};
        pb.setDemand(demand);
        int costs[][] = {
                {2, 3, 1},
                {5, 4, 8},
                {5, 6, 8}
        };
        pb.setCost(costs);
        Source s1 = new Warehouse("S1");
        System.out.println(s1);
        Source s2 = new Factory("S2");
        System.out.println(s2);
        Source s3 = new Factory("S3");
        System.out.println(s3);
        Source[] sources = new Source[]{s1, s2, s3};
        pb.setSources(sources);
        Destination d1 = new Destination("destinationNumber1");
        System.out.println(d1);
        Destination d2 = new Destination("destinationNumber2");
        System.out.println(d2);
        Destination d3 = new Destination("destinationNumber3");
        Destination[] destinations = new Destination[]{
                d1, d2, d3
        };
        pb.setDestinations(destinations);

        System.out.println(d3);
        System.out.println(pb);

    }
}