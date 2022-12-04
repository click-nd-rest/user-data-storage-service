package com.github.click.nd.rest.uds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
        (exclude = {
                org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
                org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
        )

public class UserDataStorageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserDataStorageServiceApplication.class, args);
    }

}
