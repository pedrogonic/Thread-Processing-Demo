package com.pedrogonic.threadprocessingdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ThreadProcessingDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThreadProcessingDemoApplication.class, args);
    }

}
