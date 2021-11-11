package com.example.sentinel.models;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class StatsResponseModel {
    
    private Integer countMutantDna = 0;
    private Integer countHumanDna = 0;
    private String ratio;

    public StatsResponseModel(Integer countMutantDna, Integer countHumanDna) {
        this.countMutantDna = countMutantDna;
        this.countHumanDna = countHumanDna;
        DecimalFormat df = new DecimalFormat("#,###");
        df.setRoundingMode(RoundingMode.HALF_UP);
        this.ratio = df.format(countMutantDna / countHumanDna);;
    }

    public void setCountMutantDna(Integer value){ countMutantDna = value; }
    public void setCountHumanDna(Integer value){ countHumanDna = value; }

    public Integer getCountMutantDna(){ return countMutantDna; }
    public Integer getCountHumanDna(){ return countHumanDna; }
    public String getRation() { return ratio; }

}
