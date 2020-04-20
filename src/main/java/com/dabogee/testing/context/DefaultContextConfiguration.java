package com.dabogee.testing.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.dabogee.testing"})
public class DefaultContextConfiguration {
}
