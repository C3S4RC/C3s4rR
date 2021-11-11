package com.example.sentinel.controllers;

import com.example.sentinel.models.StatsResponseModel;
import com.example.sentinel.services.StatsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsController {

    @Autowired
    StatsService statsService;

    @GetMapping()
    public StatsResponseModel stats(){
        return statsService.getStats();
    }
    
}
