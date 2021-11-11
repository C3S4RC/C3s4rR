package com.example.sentinel.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.sentinel.exceptions.*;
import com.example.sentinel.models.Mutant;
import com.example.sentinel.models.Person;
import com.example.sentinel.repository.SentinelRepository;

@Service
public class SentinelService {

    Logger logger = Logger.getLogger(SentinelService.class.getName());
    
    public boolean isMutant(String[] dna){
        if(dna.length <= 0){
            logger.log(Level.WARNING, "Invalid arguntents");
            return false;
        }

        try {
            Integer cant = 0;
            logger.log(Level.INFO, "Start Diagonals chek");
            if(validateDiagonals(dna) == true)
                cant +=1;
            logger.log(Level.INFO, "Start Vertical chek");
            if(validateVerticals(dna) == true)
                cant +=1;
            logger.log(Level.INFO, "Start Horizontal chek");
            if(validateHorizontals(dna) == true)
                cant +=1;
            if(cant >=3) {
                logger.log(Level.WARNING, "Is Mutant");
                SentinelRepository.getInstance().getExamples().add(new Mutant(dna));
                return true;
            } else {
                logger.log(Level.INFO, "Is Human");
                SentinelRepository.getInstance().getExamples().add(new Person(dna));
                return false;
            }
        } catch (BadDataException e) {
            logger.log(Level.WARNING, "Invalid arguntents");
            return false;
        }
        
    }

    
    private boolean validateVerticals(String[] dna) throws BadDataException {
        List<String> newDan = new ArrayList<String>();
        for (int i = 0; i < 6; i++) {
            StringBuilder file1 = new StringBuilder();
            for (String item : dna) {
                char[] ch = item.toCharArray();
                file1.append(ch[i]);
            }
            newDan.add(file1.toString());
        }
        try {
            return validateHorizontals(newDan.toArray(new String[0]));
        } catch (BadDataException e) {
            throw e;
        }
        
    }

    private boolean validateDiagonals(String[] dna) throws BadDataException {

        List<String> newDan = new ArrayList<String>();
        StringBuilder file1 = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            file1.append(dna[i].toCharArray()[i]);
        }
        StringBuilder file2 = new StringBuilder();
        for (int i = 1; i < 6; i++) {
            file2.append(dna[i].toCharArray()[i-1]);
        }
        StringBuilder file3 = new StringBuilder();
        for (int i = 1; i < 6; i++) {
            file3.append(dna[i-1].toCharArray()[i]);
        }
        StringBuilder file4 = new StringBuilder();
        for (int i = 2; i < 6; i++) {
            file4.append(dna[i].toCharArray()[i-2]);
        }
        StringBuilder file5 = new StringBuilder();
        for (int i = 2; i < 6; i++) {
            file5.append(dna[i-2].toCharArray()[i]);
        }
        newDan.add(file1.toString());
        newDan.add(file2.toString());
        newDan.add(file3.toString());
        newDan.add(file4.toString());
        newDan.add(file5.toString());
        try {
            return validateHorizontals(newDan.toArray(new String[0]));
        } catch (BadDataException e) {
           throw e;
        }
        
    }

    private boolean validateHorizontals(String[] dna) throws BadDataException{
        try {
            validate(dna);
        } catch (BadDataException ex){
            throw ex;
        } catch (Exception e) {
            return true;
        }
        return false;
    }
    
    private void validate(String[] dna) throws Exception, BadDataException {
        for (String item : dna) {
            char[] ch = item.toCharArray();
            boolean result = false;
            for (char leter : ch) {
                try {
                    result = checkDuplicates(ch, leter);
                } catch (BadDataException e) {
                    throw e;
                }
                if(result == true){
                    logger.log(Level.WARNING, "dna " + item + " " + result);
                    throw new Exception("Is Mutant!");
                }
            }
            logger.log(Level.INFO, "dna " + item + " " + result);
            System.out.println();
        }
    }

    //Valida si hay cuates letras iguales seguidas
    boolean checkDuplicates(char[] leters, char item) throws BadDataException
    {
        String validLeters = "ATCG";

        if(!validLeters.contains(Character.toString(item)))
            throw new BadDataException("Bad data request");

        Integer count = 0;
        for (int i = 0; i < leters.length; i++) {
            if(leters[i] == item)
                count += 1;
            else
                count -= 1;
            if(count>3) {
                return true;
            }
        }
        return false;
    }
}
