package com.bookmyshow.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Slf4j
public final class BookMyShowUtil {

    public static ObjectMapper mapper() {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);


        return mapper;
    }

    public static LocalDate toDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        log.info("date :: {}", localDate);
        return localDate;
    }
    public static LocalDateTime toDateTime(String date) {
        String str = "1986-04-08 12:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        return dateTime;
    }

    public static String dateTimeToDateTimeString(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = localDateTime.format(formatter);
        return formattedDateTime;
    }
    public static String dateTimeToDateString(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDateTime = localDateTime.format(formatter);
        return formattedDateTime;
    }

    public static void main(String[] args) {
        log.info("date :: {}", dateTimeToDateTimeString(toDateTime("2023-01-15 17:00")));
    }

}
