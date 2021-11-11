package com.example.sentinel.models;

public class Person extends HumanBeing {

    public Person(String[] dna){
        this.dna = dna;
        this.havePowers = false;
    }

    public Person(){
        havePowers = false;
    }
}
