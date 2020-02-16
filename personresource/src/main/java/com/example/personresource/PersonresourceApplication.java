package com.example.personresource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@SpringBootApplication
public class PersonresourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonresourceApplication.class, args);
    }

}
