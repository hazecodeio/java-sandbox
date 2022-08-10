package org.hsmak.random.datetime;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Stream;

//ToDo
public class DateTimeWithStepSize {
    public static void main(String[] args) {
        var currentDate = LocalDate.now().minusDays(1).minusYears(2);
        var pastDate = currentDate.minusWeeks(2).plusDays(4);

        Stream.of(currentDate).map(d -> "currentDate:   " + d).forEach(System.out::println);
        Stream.of(pastDate).map(d -> "pastDate:   " + d).forEach(System.out::println);

        List<Integer> stepSizeOfDaysList = prepareDataForStepSizeOfDays(currentDate);

        for (int stepSizeOfDays : stepSizeOfDaysList) {

            Stream.of("------\n",
                    "StepSize:", stepSizeOfDays, "\nCurrentDate:   ", currentDate, "\nPastDate:    ", pastDate, "\n------\n").forEach(System.out::print);

            var futureDate = moveDateWithStepSize(pastDate, currentDate, stepSizeOfDays);
            Stream.of(futureDate).map(LocalDate::toString).forEach(System.out::println);

            var anotherPast = pastDate.minusDays(1);
            futureDate = anotherPast.plusDays((long) (stepSizeOfDays * (Math.ceil(Period.between(anotherPast, currentDate).getDays() / (double) stepSizeOfDays))));
            System.out.println(futureDate);

            anotherPast = pastDate.minusDays(2);
            futureDate = anotherPast.plusDays((long) (stepSizeOfDays * (Math.ceil(Period.between(anotherPast, currentDate).getDays() / (double) stepSizeOfDays))));
            System.out.println(futureDate);

            anotherPast = pastDate.minusDays(3);
            futureDate = anotherPast.plusDays((long) (stepSizeOfDays * (Math.ceil(Period.between(anotherPast, currentDate).getDays() / (double) stepSizeOfDays))));
            System.out.println(futureDate);

            anotherPast = pastDate.minusDays(4);
            futureDate = anotherPast.plusDays((long) (stepSizeOfDays * (Math.ceil(Period.between(anotherPast, currentDate).getDays() / (double) stepSizeOfDays))));
            System.out.println(futureDate);

            anotherPast = pastDate.minusDays(5);
            futureDate = anotherPast.plusDays((long) (stepSizeOfDays * (Math.ceil(Period.between(anotherPast, currentDate).getDays() / (double) stepSizeOfDays))));
            System.out.println(futureDate);

            anotherPast = pastDate.minusDays(6);
            futureDate = anotherPast.plusDays((long) (stepSizeOfDays * (Math.ceil(Period.between(anotherPast, currentDate).getDays() / (double) stepSizeOfDays))));
            System.out.println(futureDate);

            anotherPast = pastDate.minusDays(7);
            futureDate = anotherPast.plusDays((long) (stepSizeOfDays * (Math.ceil(Period.between(anotherPast, currentDate).getDays() / (double) stepSizeOfDays))));
            System.out.println(futureDate);

            anotherPast = pastDate.minusDays(8);
            futureDate = anotherPast.plusDays((long) (stepSizeOfDays * (Math.ceil(Period.between(anotherPast, currentDate).getDays() / (double) stepSizeOfDays))));
            System.out.println(futureDate);
        }

//        var now_MonthLength = currentDate.getMonth().length(currentDate.isLeapYear());


    }

    //ToDo - Code another strategy to calculate the # days in between using `LocalDate.now.get(ChronoField.DAY_OF_YEAR)`
    private static List<Integer> prepareDataForStepSizeOfDays(LocalDate currentDate) {
        List<Integer> stepSizeOfDaysList = List.of(7,
                currentDate.getMonth().length(currentDate.isLeapYear()),

                currentDate.getMonth().minus(1).length(currentDate.isLeapYear()) +
                        Stream.iterate(0, m -> m + 1).limit(1).mapToInt(m -> currentDate.getMonth().plus(m).length(currentDate.plusMonths(m).isLeapYear())).sum(),

                currentDate.getMonth().minus(1).length(currentDate.isLeapYear()) +
                        Stream.iterate(0, m -> m + 1).limit(2).mapToInt(m -> currentDate.getMonth().plus(m).length(currentDate.plusMonths(m).isLeapYear())).sum(),

                currentDate.getMonth().minus(1).length(currentDate.isLeapYear()) +
                        Stream.iterate(0, m -> m + 1).limit(3).mapToInt(m -> currentDate.getMonth().plus(m).length(currentDate.plusMonths(m).isLeapYear())).sum(),

                currentDate.getMonth().minus(1).length(currentDate.isLeapYear()) +
                        Stream.iterate(0, m -> m + 1).limit(4).mapToInt(m -> currentDate.getMonth().plus(m).length(currentDate.plusMonths(m).isLeapYear())).sum(),

                currentDate.getMonth().minus(1).length(currentDate.isLeapYear()) +
                        Stream.iterate(0, m -> m + 1).limit(5).mapToInt(m -> currentDate.getMonth().plus(m).length(currentDate.plusMonths(m).isLeapYear())).sum(),

                currentDate.getMonth().minus(1).length(currentDate.isLeapYear()) +
                        Stream.iterate(0, m -> m + 1).limit(6).mapToInt(m -> currentDate.getMonth().plus(m).length(currentDate.plusMonths(m).isLeapYear())).sum(),

                currentDate.getMonth().minus(1).length(currentDate.isLeapYear()) +
                        Stream.iterate(0, m -> m + 1).limit(7).mapToInt(m -> currentDate.getMonth().plus(m).length(currentDate.plusMonths(m).isLeapYear())).sum(),

                currentDate.getMonth().minus(1).length(currentDate.isLeapYear()) +
                        Stream.iterate(0, m -> m + 1).limit(8).mapToInt(m -> currentDate.getMonth().plus(m).length(currentDate.plusMonths(m).isLeapYear())).sum());

                /*currentDate.getMonth().minus(1).length(currentDate.isLeapYear()) +
                        currentDate.getMonth().length(currentDate.isLeapYear()) +
                        currentDate.getMonth().plus(1).length(currentDate.isLeapYear()),

                currentDate.getMonth().minus(1).length(currentDate.isLeapYear()) +
                        currentDate.getMonth().length(currentDate.isLeapYear()) +
                        currentDate.getMonth().plus(1).length(currentDate.isLeapYear()) +
                        currentDate.getMonth().plus(2).length(currentDate.isLeapYear()),

                currentDate.getMonth().minus(1).length(currentDate.isLeapYear()) +
                        currentDate.getMonth().length(currentDate.isLeapYear()) +
                        currentDate.getMonth().plus(1).length(currentDate.isLeapYear()) +
                        currentDate.getMonth().plus(2).length(currentDate.isLeapYear()) +
                        currentDate.getMonth().plus(3).length(currentDate.isLeapYear()),

                currentDate.getMonth().minus(1).length(currentDate.isLeapYear()) +
                        currentDate.getMonth().length(currentDate.isLeapYear()) +
                        currentDate.getMonth().plus(1).length(currentDate.isLeapYear()) +
                        currentDate.getMonth().plus(2).length(currentDate.isLeapYear()) +
                        currentDate.getMonth().plus(3).length(currentDate.isLeapYear()) +
                        currentDate.getMonth().plus(4).length(currentDate.isLeapYear()),

                currentDate.getMonth().minus(1).length(currentDate.isLeapYear()) +
                        currentDate.getMonth().length(currentDate.isLeapYear()) +
                        currentDate.getMonth().plus(1).length(currentDate.isLeapYear()) +
                        currentDate.getMonth().plus(2).length(currentDate.isLeapYear()) +
                        currentDate.getMonth().plus(3).length(currentDate.isLeapYear()) +
                        currentDate.getMonth().plus(4).length(currentDate.isLeapYear()) +
                        currentDate.getMonth().plus(5).length(currentDate.plusMonths(5).isLeapYear()),
                currentDate.getMonth().minus(1).length(currentDate.isLeapYear()) +
                        currentDate.getMonth().length(currentDate.isLeapYear()) +
                        currentDate.getMonth().plus(1).length(currentDate.isLeapYear()) +
                        currentDate.getMonth().plus(2).length(currentDate.isLeapYear()) +
                        currentDate.getMonth().plus(3).length(currentDate.isLeapYear()) +
                        currentDate.getMonth().plus(4).length(currentDate.isLeapYear()) +
                        currentDate.getMonth().plus(5).length(currentDate.plusMonths(5).isLeapYear()) +
                        currentDate.getMonth().plus(6).length(currentDate.plusMonths(6).isLeapYear()));*/

//        Stream.iterate(0, i -> i+1).
        return stepSizeOfDaysList;
    }

    public static LocalDate moveDateWithStepSize(LocalDate past, LocalDate now, int stepSize) {
        var future = past.plusDays(
                (long) (stepSize * (Math.ceil(Period.between(past, now).getDays() / (double) stepSize)))
        );
        return future;
    }
}
