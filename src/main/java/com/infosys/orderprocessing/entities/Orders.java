package com.infosys.orderprocessing.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Orders {
	@Id
	@Column(name="order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	@Column(name="no_of_items_ordered")
	private int noOfItemsOrdered;
	
	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@ManyToMany
	private List<Product> product;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getNoOfItemsOrdered() {
		return noOfItemsOrdered;
	}

	public void setNoOfItemsOrdered(int noOfItemsOrdered) {
		this.noOfItemsOrdered = noOfItemsOrdered;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
}
