package com.infosys.orderprocessing.exceptions;


public class CustomerNotFoundException extends ApplicationException{
    private String message;

    public CustomerNotFoundException(String message) {
        super(message);
        this.message = message;
    }

}
