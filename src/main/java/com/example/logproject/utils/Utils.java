package com.example.logproject.utils;

import com.example.logproject.domain.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";
    public static SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);

    public static Log parseLog(String line) throws ParseException {
        Log log = new Log();
        // TODO parse using regular expression
//        String pat = "\\w+\\s+:\\s+.{23}\\s+.+";
//        String[] s__ = line.split(pat);

        // TODO add parameters validation
        String[] arr = line.split(" ");
        findLevel(arr);
        log.setLevel(findLevel(arr));
        String dt = findDateTime(arr);
        Date date = parseDate(dt);
        log.setDateTime(date);
        log.setMessage(findMessage(line));
        return log;
    }

    public static Date parseDate(String dt) throws ParseException {
        return sdf.parse(dt);
    }

    private static String findMessage(String line) {
        String[] arr = line.split(" ", 5);
        return arr[4];
    }

    private static String findDateTime(String[] arr) {
        return arr[2] + " " + arr[3];
    }

    private static String findLevel(String[] arr) {
         return arr[0];
    }
}
