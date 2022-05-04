package com.infosys.orderprocessing.exceptions;

public class ApplicationException extends RuntimeException{
    private String message;

    public ApplicationException(String message) {
        super(message);
        this.message = message;
    }
}
