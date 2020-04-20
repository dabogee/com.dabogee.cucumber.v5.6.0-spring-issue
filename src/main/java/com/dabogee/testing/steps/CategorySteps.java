package com.dabogee.testing.steps;

import io.cucumber.java.en.Given;
import lombok.extern.log4j.Log4j2;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class CategorySteps extends ParentCleanableSteps {

    private String category;

    @Given("Set category to {}")
    public void setCategory(String category) {
        this.category = category;
    }

    @Given("Current category is {}")
    public void checkCategory(String expected) {
        assertThat(this.category).isEqualToIgnoringCase(expected);
    }
}
