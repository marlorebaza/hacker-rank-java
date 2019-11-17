package com.marlo.java;

import java.text.DateFormatSymbols;
import java.util.*;

public class Various {
    private static String getDay(String day, String month, String year) {
        Calendar c = new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month)-1, Integer.parseInt(day));
        DateFormatSymbols dfs = new DateFormatSymbols(new Locale("us"));
        return dfs.getWeekdays()[c.get(Calendar.DAY_OF_WEEK)].toUpperCase();
    }

    public static void main(String[] args) {
        /*
        Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();
        System.out.println(getDay(day, month, year));
        */
        System.out.println("000.12.12.034".matches(pattern()));
        System.out.println("121.234.12.12".matches(pattern()));
        System.out.println("23.45.12.56".matches(pattern()));
        System.out.println("00.12.123.123123.123".matches(pattern()));
        System.out.println("122.23".matches(pattern()));
        System.out.println("Hello.IP".matches(pattern()));


    }

    public static String pattern() {
        return "^([0-9]{1,2}|[01][0-9][0-9]|2[0-5][0-5]){1}\\.([0-9]{1,2}|[01][0-9][0-9]|2[0-5][0-5]){1}\\.([0-9]{1,2}|[01][0-9][0-9]|2[0-5][0-5]){1}\\.([0-9]{1,2}|[01][0-9][0-9]|2[0-5][0-5]){1}$";
    }

}
