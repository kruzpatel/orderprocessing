package com.infosys.orderprocessing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.orderprocessing.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
