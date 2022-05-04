package com.infosys.orderprocessing.controllers;

import com.infosys.orderprocessing.exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.infosys.orderprocessing.entities.Customer;
import com.infosys.orderprocessing.repositories.CustomerRepository;
import com.infosys.orderprocessing.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Customer customer) {
		Customer createdCustomer = customerService.createCustomer(customer);
		return ResponseEntity.ok().body(createdCustomer);
	}


	@GetMapping("/{customerId}")
	public ResponseEntity<?> getCustomer(@PathVariable int customerId){
		Customer customer = customerService.getCustomerById(customerId);
		return ResponseEntity.ok().body(customer);
	}

	@GetMapping
	public ResponseEntity<?>  getAllCustomer(){
		List<Customer> customers = customerService.getAllCustomer();
		return customers.isEmpty()
				? ResponseEntity.status(HttpStatus.NO_CONTENT).body("Customers are not exist")
				:ResponseEntity.ok().body(customers);
	}


}
