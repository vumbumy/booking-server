package com.example.booking.config;

import com.example.booking.rest.BookingService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {

        register(BookingService.class);
    }
}
