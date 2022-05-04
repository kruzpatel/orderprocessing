package com.infosys.orderprocessing.exceptionhandler;

import com.infosys.orderprocessing.exceptions.ApplicationException;
import com.infosys.orderprocessing.exceptions.CustomerNotFoundException;
import com.infosys.orderprocessing.exceptions.ProductOutOfStockException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {


 
 @ExceptionHandler(ProductOutOfStockException.class)
 public ResponseEntity<String> handleProductOutOfStockException(ProductOutOfStockException ex){
     return ResponseEntity.status(HttpStatus.OK).body(ex.getMessage());
 }


    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<String> handleApplicationException(ApplicationException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }


}
