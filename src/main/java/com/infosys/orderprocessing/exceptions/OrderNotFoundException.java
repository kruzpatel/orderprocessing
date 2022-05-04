package com.infosys.orderprocessing.exceptions;

public class OrderNotFoundException extends ApplicationException{
    private String message;

    public OrderNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
