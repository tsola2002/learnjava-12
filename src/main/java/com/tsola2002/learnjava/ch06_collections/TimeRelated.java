package com.tsola2002.learnjava.ch06_collections;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class TimeRelated {

  public static void main(String[] args) {

    //localDate();

    //localTimeFunctions();

    //localDateTimeFunctions();

    periodAndDuration();

  }

  private static void periodAndDuration() {

//    LocalDateTime ldt1 = LocalDateTime.parse("2020-02-23T20:23:12");
//    LocalDateTime ldt2 = ldt1.plus(Period.ofYears(3));
//    System.out.println(ldt2); //prints: 2022-02-23T20:23:12

    LocalTime lt1 = LocalTime.parse("10:23:12");
    LocalTime lt2 = LocalTime.parse("20:23:14");
    Duration duration = Duration.between(lt1, lt2);
    System.out.println(duration.toDays()); //prints: 0
    System.out.println(duration.toHours()); //prints: 10
    System.out.println(duration.toMinutes()); //prints: 600
    System.out.println(duration.toSeconds()); //prints: 36002
    System.out.println(duration.getSeconds()); //prints: 36002

  }

  private static void localDateTimeFunctions() {

   // System.out.println(LocalDateTime.now());

//    ZoneId zoneId = ZoneId.of("Asia/Tokyo");
//    System.out.println(LocalDateTime.now(zoneId));
//
//    LocalDateTime ldt1 = LocalDateTime.parse("2020-02-23T20:23:12");
//    System.out.println(ldt1);

//    DateTimeFormatter formatter =
//        DateTimeFormatter.ofPattern("HH:mm:ss yyyy/MM/dd");
//
//    LocalDateTime ldt2 =
//        LocalDateTime.parse("20:23:12 2023/02/25", formatter);
//      System.out.println(ldt2);

//    LocalDateTime ldt3 =
//        LocalDateTime.of(2020, 2, 23, 20, 23, 12);
//    System.out.println(ldt3);

    LocalDate ld = LocalDate.of(2020, 2, 23);
    LocalTime lt = LocalTime.of(20, 23, 12);
    LocalDateTime ldt5 = LocalDateTime.of(ld, lt);
    System.out.println(ldt5);

  }

  private static void localTimeFunctions() {
    //System.out.println(LocalTime.now());

    //ZoneId zoneId = ZoneId.of("Asia/Tokyo");

    //System.out.println(LocalTime.now(zoneId));

//    LocalTime lt1 = LocalTime.parse("20:23:12");
//    System.out.println(lt1);

//    LocalTime lt2 = LocalTime.of(20, 23, 12);
//    System.out.println(lt2);

//
    LocalTime lt2 = LocalTime.of(20, 23, 12);
    System.out.println(lt2.withHour(3)); //prints: 03:23:12
    System.out.println(lt2.withMinute(10)); //prints: 20:10:12
    System.out.println(lt2.withSecond(15)); //prints: 20:23:15
    System.out.println(lt2.withNano(300)); //prints: 20:23:12.000000300
    System.out.println(lt2.plusHours(10)); //prints: 06:23:12
    System.out.println(lt2.plusMinutes(2)); //prints: 20:25:12
    System.out.println(lt2.plusSeconds(2)); //prints: 20:23:14
    System.out.println(lt2.plusNanos(200)); //prints: 20:23:12.000000200
     System.out.println(lt2.minusHours(10)); //prints: 10:23:12
     System.out.println(lt2.minusMinutes(2)); //prints: 20:21:12
     System.out.println(lt2.minusSeconds(2)); //prints: 20:23:10
     System.out.println(lt2.minusNanos(200)); //prints: 20:23:11.999999800

  }

  private static void localDate() {
    //System.out.println(LocalDate.now());

//    Set<String> zoneIds = ZoneId.getAvailableZoneIds();
//    for(String zoneId: zoneIds){
//     // System.out.println(zoneId);
//    }

    //America/Toronto
//    ZoneId zoneId = ZoneId.of("America/Toronto");
//    System.out.println(LocalDate.now(zoneId));

//    LocalDate lc1 = LocalDate.parse("2023-01-13");
//    System.out.println(lc1);

//    LocalDate lc2 = LocalDate.parse("19960123",
//        DateTimeFormatter.BASIC_ISO_DATE);
//    System.out.println(lc2); //prints: 2020-02-23

//    LocalDate lc4 = LocalDate.of(2020, 2, 23);
//    System.out.println(lc4); //prints: 2020-02-23

//      LocalDate lc5 = LocalDate.of(2020, Month.FEBRUARY, 23);
//      System.out.println(lc5); //prints: 2020-02-23

//    LocalDate lc6 = LocalDate.ofYearDay(2023, 72);
//    System.out.println(lc6); //prints: 2020-02-23

   // LocalDate lc = LocalDate.parse("2020-02-23");
//    LocalDate lc = LocalDate.of(2020, 2, 23);
//    System.out.println(lc.withYear(2021)); //prints: 2021-02-23
//    System.out.println(lc.withMonth(5)); //prints: 2020-05-23
//    System.out.println(lc.withDayOfMonth(5)); //prints: 2020-02-05
//    System.out.println(lc.withDayOfYear(53)); //prints: 2020-02-22
//    System.out.println(lc.plusDays(10)); //prints: 2020-03-04
//    System.out.println(lc.plusMonths(2)); //prints: 2020-04-23
//    System.out.println(lc.plusYears(2)); //prints: 2022-02-23 System.out.println(lc.minusDays(10)); //prints: 2020-02-13 System.out.println(lc.minusMonths(2)); //prints: 2019-12-23 System.out.println(lc.minusYears(2)); //prints: 2018-02-23

    LocalDate lc1 = LocalDate.parse("2020-02-23");
    LocalDate lc2 = LocalDate.parse("2020-02-22");
    System.out.println(lc1.isAfter(lc2)); //prints: true
    System.out.println(lc1.isBefore(lc2)); //prints: false

  }

}
