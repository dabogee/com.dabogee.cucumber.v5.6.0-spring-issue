package com.dabogee.testing.steps.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.dabogee.testing.steps"})
public class DefaultContextConfiguration {
}
