package com.infosys.orderprocessing.controllers;


import com.infosys.orderprocessing.entities.Orders;
import com.infosys.orderprocessing.services.OrdersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;


    @PostMapping("/customers/{customerId}/{productId}/{quantity}")
    public ResponseEntity<?> create(@PathVariable int customerId,@PathVariable int productId,@PathVariable int quantity){
       Orders order = ordersService.createOrder(customerId,productId,quantity);
       return ResponseEntity.ok().body(order);

    }


    @PostMapping("/customers/{customerId}/products")
    public ResponseEntity<?> create(@PathVariable int customerId,@RequestParam String ids){
        Orders order = ordersService.createOrder(customerId, Arrays.asList(ids.split(",")).stream().mapToInt(Integer::parseInt).toArray());
        return ResponseEntity.ok().body(order);
    }


    @GetMapping("/customer/{customerId}")
    public ResponseEntity<?> getOrderDetails(@PathVariable int customerId){
      return ResponseEntity.ok().body(ordersService.getOrderDetailsByCustomerId(customerId));
    }

}
