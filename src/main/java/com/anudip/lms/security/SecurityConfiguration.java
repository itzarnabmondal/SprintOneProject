package com.anudip.lms.security;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.anudip.lms.authentication.AdminDetails;

/**
 * Configuration class for in-memory authentication.
 * 
 * This class is annotated with `@Configuration`, which indicates that it is a
 * Spring configuration
 * class. It is responsible for configuring the authentication manager with
 * in-memory users.
 * 
 * The `@Bean` annotation on the `configure` method indicates that the method
 * returns a bean that will
 * be managed by the Spring container. The `@Primary` annotation indicates that
 * this bean should be
 * given preference when multiple beans of the same type are present.
 */
@Configuration
public class SecurityConfiguration {
    private final Map<String, String> admins;

    /**
     * Constructs a new `SecurityConfiguration` instance.
     * 
     * This constructor initializes the `admins` field with the map of admin users
     * returned by the
     * `AdminDetails.getAdmins()` method.
     */
    public SecurityConfiguration() {
        this.admins = AdminDetails.getAdmins();
    }

    /**
     * Configures the authentication manager with in-memory users.
     * 
     * This method takes an `AuthenticationManagerBuilder` as an argument and uses
     * it to configure the
     * authentication manager with in-memory users. It iterates over the map of
     * admin users and
     * creates a `UserDetails` object for each user using the `User` utility class
     * and the default
     * password encoder. The `UserDetails` object is then added to the
     * authentication manager using
     * the `withUser` method.
     * 
     * @param auth the `AuthenticationManagerBuilder` to use for configuring the
     *             authentication manager
     * @return the `AuthenticationManagerBuilder` after it has been configured with
     *         in-memory users
     * @throws Exception if an error occurs while configuring the authentication
     *                   manager
     */
    @Bean
    @Primary
    AuthenticationManagerBuilder configure(AuthenticationManagerBuilder auth) throws Exception {
        for (Map.Entry<String, String> entry : admins.entrySet()) {
            String username = entry.getKey();
            String password = entry.getValue();
            UserDetails user = User.withDefaultPasswordEncoder()
                    .username(username)
                    .password(password)
                    .roles("ADMIN")
                    .build();
            auth.inMemoryAuthentication().withUser(user);
        }
        return auth;
    }
}
