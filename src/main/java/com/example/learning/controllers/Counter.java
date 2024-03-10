package com.example.learning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learning.services.impl.CounterService;

@RestController
public class Counter {
    @Autowired
    private CounterService counterService;

    @GetMapping("/counter")
    public ResponseEntity<?> getCount() {
        int currentCount = counterService.getNextCount();
        int currentCountWithoutCache = counterService.getNextCountWithoutCache();
        System.out.println("Current counter: " + currentCount);
        System.out.println("Current current count without cache: " + currentCountWithoutCache);
        return ResponseEntity.ok(currentCount);
    }
}
