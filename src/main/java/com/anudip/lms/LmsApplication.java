package com.anudip.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

/**
 * The main class for the LMS application.
 * 
 * This class is annotated with `@SpringBootApplication`, which is a convenience
 * annotation that
 * combines several other Spring Boot annotations. It enables component
 * scanning, autoconfiguration,
 * and property support.
 * 
 * The `exclude` attribute of the `@SpringBootApplication` annotation is used to
 * exclude certain
 * auto-configuration classes. In this case, the
 * `UserDetailsServiceAutoConfiguration` class is
 * excluded.
 */
@SpringBootApplication(exclude = { UserDetailsServiceAutoConfiguration.class })
public class LmsApplication {

    /**
     * The main method for the LMS application.
     * 
     * This method is the entry point of the application and is responsible for
     * starting the LMS
     * application using Spring Boot's `SpringApplication` class.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        // Start the LMS application using Spring Boot's SpringApplication class
        SpringApplication.run(LmsApplication.class, args);
    }
}
