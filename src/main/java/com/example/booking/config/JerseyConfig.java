package com.example.booking.config;

import com.example.booking.authentication.AuthenticationService;
import com.example.booking.authentication.RestAuthenticationFilter;
import com.example.booking.rest.BookingExceptionMapper;
import com.example.booking.rest.BookingService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {

        register(BookingExceptionMapper.class);
        register(RestAuthenticationFilter.class);
        register(BookingService.class);
    }
}
