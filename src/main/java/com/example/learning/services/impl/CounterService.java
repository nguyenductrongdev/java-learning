package com.example.learning.services.impl;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CounterService {
    private static int count = 0;

    @Cacheable("counter")
    public int getNextCount() {
        CounterService.count++;
        return count;
    }

    @CacheEvict("counter")
    public int getNextCountWithoutCache() {
        CounterService.count++;
        return count;
    }
}
