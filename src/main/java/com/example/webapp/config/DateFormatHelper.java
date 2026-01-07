package com.example.webapp.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatHelper {
    public String convertMyDateFormat() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return date.format(dtf);
    }
}
