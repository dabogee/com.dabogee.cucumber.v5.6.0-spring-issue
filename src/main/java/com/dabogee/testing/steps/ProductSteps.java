package com.dabogee.testing.steps;

import io.cucumber.java.en.Given;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

@Log4j2
public class ProductSteps extends ParentCleanableSteps {

    @Autowired
    private ProductComponent products;

    @Given("Add a new product to shopping cart")
    public void addNew() {
        log.info("Adding a new product item to shopping cart..");
        products.put(RandomStringUtils.randomAlphabetic(32));
    }

    @Given("Shopping cart is empty")
    public void isEmpty() {
        hasItems(0);
    }

    @Given("Shopping cart contains {int} item(s)")
    public void hasItems(Integer count) {
        log.info("Checking shopping cart size equals to {}..", count);
        assertThat(products.getProducts()).hasSize(count);
    }

    @Given("Wait {int} seconds")
    public void doWait(Integer seconds) {
        await().atLeast(seconds, TimeUnit.SECONDS);
    }
}
