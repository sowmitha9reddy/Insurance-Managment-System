package com.Insurance.Insurance.System.exception;

public class ClaimNotFoundException extends RuntimeException{
    public ClaimNotFoundException(String message){
        super(message);
    }

}
