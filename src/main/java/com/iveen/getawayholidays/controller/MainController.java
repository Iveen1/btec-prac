package com.iveen.getawayholidays.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Polyakov Anton
 * @created 21.06.2022 17:50
 * @project getaway-holidays
 */

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class MainController {
    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
