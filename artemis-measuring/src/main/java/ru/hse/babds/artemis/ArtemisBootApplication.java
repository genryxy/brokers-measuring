package ru.hse.babds.artemis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ArtemisBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArtemisBootApplication.class, args);
    }
}
