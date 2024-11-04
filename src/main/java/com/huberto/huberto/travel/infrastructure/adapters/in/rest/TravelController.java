package com.huberto.huberto.travel.infrastructure.adapters.in.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/travel")
public class TravelController {

    @PostMapping("/request")
    public ResponseEntity<String> register() {
        return ResponseEntity.ok("OK");
    }
}
