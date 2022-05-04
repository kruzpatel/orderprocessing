package com.infosys.orderprocessing.controllers;

import com.infosys.orderprocessing.entities.Customer;
import com.infosys.orderprocessing.entities.Product;
import com.infosys.orderprocessing.services.CustomerService;
import com.infosys.orderprocessing.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.ok().body(createdProduct);
    }


    @GetMapping("/{productId}")
    public ResponseEntity<?> getProduct(@PathVariable int productId){
            Product product = productService.getProductById(productId);
            return ResponseEntity.ok().body(product);
    }

    @GetMapping
    public ResponseEntity<?>  getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok().body(products);
    }


}
