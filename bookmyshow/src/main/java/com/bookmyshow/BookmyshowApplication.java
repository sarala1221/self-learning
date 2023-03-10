package com.bookmyshow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
//@ComponentScan(basePackages = "com.bookmyshow.*")
public class BookmyshowApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookmyshowApplication.class, args);
    }

}
