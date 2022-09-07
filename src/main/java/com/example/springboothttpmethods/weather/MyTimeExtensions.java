package com.example.springboothttpmethods.weather;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyTimeExtensions {

    public static String toDanishFormat(LocalDateTime localDateTime, String complaint) {
        return "This is danish formatted " + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        ) + "\n" + complaint;
    }
}
