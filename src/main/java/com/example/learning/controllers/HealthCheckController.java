package com.example.learning.controllers;

import com.example.learning.dto.HealthCheckDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health-check")
public class HealthCheckController {

    @GetMapping
    private ResponseEntity<HealthCheckDTO> get() {
        return ResponseEntity.ok(new HealthCheckDTO("OK"));
    }

}
