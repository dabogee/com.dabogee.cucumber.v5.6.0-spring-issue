package com.dabogee.testing.steps.context;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

@DirtiesContext
@ContextConfiguration(classes = DefaultContextConfiguration.class)
class ContextConfigurer {
}
