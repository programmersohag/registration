package com.blog.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

@SpringBootApplication()
public class RegistrationApplication {
    //exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class}
    public static void main(String[] args) {
        SpringApplication.run(RegistrationApplication.class, args);
    }

}
