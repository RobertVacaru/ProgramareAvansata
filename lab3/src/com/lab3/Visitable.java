package com.lab3;
import java.time.LocalTime;
import java.time.Duration;
public interface Visitable {

    LocalTime getOpeningTime();
    LocalTime getClosingTime();
    default void setdefaultOpenhour(){};
    default void setdefaultClosehour(){};
    static Duration getVisitingDuration(Visitable o){
        return Duration.between(o.getOpeningTime(),o.getClosingTime());
    }


}
