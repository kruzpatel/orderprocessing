package com.infosys.orderprocessing.services;

import com.infosys.orderprocessing.exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.orderprocessing.entities.Customer;
import com.infosys.orderprocessing.repositories.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	
	
	
	public Customer createCustomer(Customer customer) {
		//validate customer 
		return customerRepository.save(customer);
		
	}

    public Customer getCustomerById(int customerId) {
		return customerRepository.findById(customerId)
				.orElseThrow(() ->new CustomerNotFoundException("Customer not found with given customer id : "+customerId));
    }

	public List<Customer> getAllCustomer(){
		List<Customer> customers = customerRepository.findAll();
		if(customers.isEmpty()){
			throw new CustomerNotFoundException("Customer is not yet registered with us");
		}
		return customers;
	}
}
