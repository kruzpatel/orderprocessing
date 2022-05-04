package com.infosys.orderprocessing.entities;

import javax.persistence.*;

@Entity
public class Customer {
	@Id
	@Column(name="customer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  customerId;
	
	@Column(name="customer_name",length = 50)
	private String customerName;
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
	
	

//table name -->	//customer_tab
	
//	column namr //customer_name
// 
}
