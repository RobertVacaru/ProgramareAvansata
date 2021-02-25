package com.lab_2;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Source s1 = new Source();
        s1.setName("S1");
        s1.setType(SourceType.WAREHOUSE);
        System.out.println(s1);
        Source s2 = new Source("S2",SourceType.FACTORY);
        System.out.println(s2);
        Source s3 = new Source("S3",SourceType.FACTORY);
        System.out.println(s3);
        Destination d1 = new Destination("destinationNumber1");
        System.out.println(d1);
        Destination d2 = new Destination("destinationNumber2");
        System.out.println(d2);
        Destination d3 = new Destination("destinationNumber3");
        System.out.println(d3);
    }
}