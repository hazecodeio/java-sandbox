package org.hsmak.random.datetime;

import java.time.LocalDate;
import java.time.Period;

//ToDo
public class DateTimeWithStepSize {
    public static void main(String[] args) {
        var now = LocalDate.now();
        var past = now.minusWeeks(2);

        var stepSize = 7; // weekly
        var future = past.plusDays((long)(stepSize*(Math.ceil(Period.between(past,now).getDays()/(double)stepSize))));
        System.out.println(future);

        var anotherPast  = past.minusDays(1);
        future = anotherPast.plusDays((long)(stepSize*(Math.ceil(Period.between(anotherPast,now).getDays()/(double)stepSize))));
        System.out.println(future);

        anotherPast  = past.minusDays(2);
        future = anotherPast.plusDays((long)(stepSize*(Math.ceil(Period.between(anotherPast,now).getDays()/(double)stepSize))));
        System.out.println(future);

        anotherPast  = past.minusDays(3);
        future = anotherPast.plusDays((long)(stepSize*(Math.ceil(Period.between(anotherPast,now).getDays()/(double)stepSize))));
        System.out.println(future);

        anotherPast  = past.minusDays(4);
        future = anotherPast.plusDays((long)(stepSize*(Math.ceil(Period.between(anotherPast,now).getDays()/(double)stepSize))));
        System.out.println(future);

        anotherPast  = past.minusDays(5);
        future = anotherPast.plusDays((long)(stepSize*(Math.ceil(Period.between(anotherPast,now).getDays()/(double)stepSize))));
        System.out.println(future);

        anotherPast  = past.minusDays(6);
        future = anotherPast.plusDays((long)(stepSize*(Math.ceil(Period.between(anotherPast,now).getDays()/(double)stepSize))));
        System.out.println(future);

        anotherPast  = past.minusDays(7);
        future = anotherPast.plusDays((long)(stepSize*(Math.ceil(Period.between(anotherPast,now).getDays()/(double)stepSize))));
        System.out.println(future);

        anotherPast  = past.minusDays(8);
        future = anotherPast.plusDays((long)(stepSize*(Math.ceil(Period.between(anotherPast,now).getDays()/(double)stepSize))));
        System.out.println(future);

//        var now_MonthLength = now.getMonth().length(now.isLeapYear());



    }
}
