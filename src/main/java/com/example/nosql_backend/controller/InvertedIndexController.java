package com.example.nosql_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class InvertedIndexController {
    @GetMapping("/inverted-index")
    public String getInvertedIndex(@RequestParam String word) {
        // Implement the logic to retrieve the inverted index based on the given word
        // Return the inverted index as the response
        System.out.println("ok");
        return "umair";
    }
}
