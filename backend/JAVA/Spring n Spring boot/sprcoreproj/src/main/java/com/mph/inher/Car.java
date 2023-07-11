package com.mph.inher;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Starting car...");
    }
}