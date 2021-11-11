package com.example.sentinel.controllers;

import com.example.sentinel.models.DnaRequestModel;
import com.example.sentinel.services.SentinelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/mutant")
public class SentinelController {
    
    @Autowired
    SentinelService sentinelService;

    @PostMapping()
    public String mutant(@RequestBody DnaRequestModel dnamodel){
        sentinelService.isMutant(dnamodel.getDna());
        return "OK";
    }
}
