package com.zhs;

import java.time.*;
import java.util.Calendar;
import java.util.Date;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/22 13:06
 * @package: com.zhs
 * @description:
 */
public class Main {

    public static void main(String[] args) {
        final Calendar calendar = DateToCalendar(new Date());
        System.out.println(calendar);

        final Date date = CalendarToDate(2020, 3, 22);
        System.out.println(date);

        final LocalDateTime localDate = DateToLocalDateTime(new Date());
        System.out.println(localDate);

        final Date date1 = LocalDateTimeToDate(LocalDateTime.now());
        System.out.println(date1);
    }

    /**
     * Caledar转Date
     * @param year
     * @param month
     * @param day
     * @return
     */
    private static Date CalendarToDate(int year,int month,int day){
       Calendar calendar = Calendar.getInstance();
       calendar.set(year,month,day);
       final Date date = calendar.getTime();
       return date;
    }

    /**
     * date转Caledar转Date
     * @param date
     * @return
     */
    private static Calendar DateToCalendar(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * 将Date转LocalDate
     * @param date
     * @return
     */
    private static LocalDateTime DateToLocalDateTime(Date date){
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
       return instant.atZone(zoneId).toLocalDateTime();
    }

    /**
     * LocalDateTime
     * @param localDateTime
     * @return
     */
    private static  Date LocalDateTimeToDate( LocalDateTime localDateTime){
        return Date.from( localDateTime.atZone( ZoneId.systemDefault()).toInstant());
    }
}
