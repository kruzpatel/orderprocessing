package com.infosys.orderprocessing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.orderprocessing.entities.Orders;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{
    List<Orders> findByCustomerCustomerId(int customerId);
}
