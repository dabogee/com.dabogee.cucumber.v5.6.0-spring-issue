package com.dabogee.testing.steps.context;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ContextShutdownHook extends ContextConfigurer {

    @Before
    public void setup() {
        log.info("Setup..");
    }

    @After
    public void teardown() {
        log.info("Shutdown..");
    }
}
