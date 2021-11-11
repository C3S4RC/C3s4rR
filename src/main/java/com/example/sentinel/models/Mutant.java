package com.example.sentinel.models;

public class Mutant extends HumanBeing{

    public Mutant(String[] dna){
        this.dna = dna;
        this.havePowers = true;
    }

    public Mutant() {
        havePowers = true;
    }
    
}
