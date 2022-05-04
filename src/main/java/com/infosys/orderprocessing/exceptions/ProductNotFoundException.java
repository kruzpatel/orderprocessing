package com.infosys.orderprocessing.exceptions;

public class ProductNotFoundException extends ApplicationException{
    private String message;

    public ProductNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
