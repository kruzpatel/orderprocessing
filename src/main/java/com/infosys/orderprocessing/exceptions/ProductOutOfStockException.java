package com.infosys.orderprocessing.exceptions;

public class ProductOutOfStockException extends ApplicationException{
    private String message;

    public ProductOutOfStockException(String message) {
        super(message);
        this.message = message;
    }
}
