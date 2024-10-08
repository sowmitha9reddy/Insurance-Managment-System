package com.Insurance.Insurance.System.exception;

public class PolicyNotFoundException extends RuntimeException{
    public PolicyNotFoundException(String message){
        super(message);
    }

}
