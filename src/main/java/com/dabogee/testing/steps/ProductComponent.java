package com.dabogee.testing.steps;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductComponent {

    @Getter
    private List<String> products = new ArrayList<>();

    public void put(String product) {
        this.products.add(product);
    }
}
