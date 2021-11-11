package com.example.sentinel.repository;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.example.sentinel.models.HumanBeing;


public class SentinelRepository {

    private static ArrayList<HumanBeing> examples;
    private static SentinelRepository instance = new SentinelRepository();

    public static SentinelRepository getInstance() {
        if (examples == null)
            examples = new ArrayList<>();
        return instance;
    }
    
    public ArrayList<HumanBeing> getExamples() { return examples; }
    public ArrayList<HumanBeing> getAllPeoples() { return (ArrayList<HumanBeing>) examples.stream().filter(p -> p.getHavePowers() == false).collect(Collectors.toList()); }
    public ArrayList<HumanBeing> getAllMuttans() { return (ArrayList<HumanBeing>) examples.stream().filter(p -> p.getHavePowers() == true).collect(Collectors.toList()); }
    
    public Integer getCantHumans(){
        return examples.stream().filter(p -> p.getHavePowers() == false).collect(Collectors.toList()).size();
    }
    public Integer getCantMutants(){
        return examples.stream().filter(p -> p.getHavePowers() == true).collect(Collectors.toList()).size();
    }
    
}
