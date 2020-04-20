package com.dabogee.testing.components;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component @Scope(SCOPE_CUCUMBER_GLUE)
public class ProductComponent {

    @Getter
    private List<String> products = new ArrayList<>();

    public void put(String product) {
        this.products.add(product);
    }
}
