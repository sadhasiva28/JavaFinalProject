package com.mph.inher;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Starting motorcycle...");
    }
}