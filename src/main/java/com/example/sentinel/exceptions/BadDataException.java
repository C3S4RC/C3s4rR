package com.example.sentinel.exceptions;

public class BadDataException extends Exception {
    
    public BadDataException(){
        super("Data is no correct");
    }

    public BadDataException(String message) {
        super(message);
    }
}
