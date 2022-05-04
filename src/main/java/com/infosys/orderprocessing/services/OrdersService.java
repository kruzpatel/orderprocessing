package com.infosys.orderprocessing.services;

import com.infosys.orderprocessing.entities.Customer;
import com.infosys.orderprocessing.entities.Product;
import com.infosys.orderprocessing.exceptions.OrderNotFoundException;
import com.infosys.orderprocessing.exceptions.ProductOutOfStockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.orderprocessing.entities.Orders;
import com.infosys.orderprocessing.repositories.OrdersRepository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersService {

	
	@Autowired
	private OrdersRepository ordersRepository;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductService productService;

	@Transactional
	public Orders createOrder(int customerId,int [] productsIds){
			Customer customer = customerService.getCustomerById(customerId);
			List<Product> products = productService.getProductsByIds(productsIds);

		List<Product> outOfStockProducts = products.stream().filter(product -> product.getProductQuantity()==0)
				.collect(Collectors.toList());
		if(!outOfStockProducts.isEmpty()){
			String outOfStockProductIds=
			outOfStockProducts.stream().map(Product::getProductId).collect(Collectors.toList()).toString();

			throw new ProductOutOfStockException("Some of the product(s) in your order are out of stock :"
					+outOfStockProductIds);
		}

		Orders order = new Orders();
		order.setCustomer(customer);
		order.setProduct(products);
		order.setNoOfItemsOrdered(products.size());

		ordersRepository.save(order);
		products.stream().forEach(product -> {
			product.setProductQuantity(product.getProductQuantity()-1);
			productService.updateProduct(product);
			}
		);


	return order;
	}

	@Transactional
	public Orders createOrder( int customerId, int productId,int requestedQuantity) {

		Product product = productService.getProductById(productId);

		if(product.getProductQuantity()==0){
			throw new ProductOutOfStockException("The Requested Product is Out of Stock, " +
					"we will inform you once it is back in stock. keep shopping");
		}else if (product.getProductQuantity() - requestedQuantity < 0){
			throw new ProductOutOfStockException("we could not process your order as" +
					" we have only "+product.getProductQuantity()+" Product(s) in stock.");
		}
		Customer customer = customerService.getCustomerById(customerId);

		product.setProductQuantity(product.getProductQuantity()-requestedQuantity);

		Orders order = new Orders();
		order.setCustomer(customer);
		order.setProduct(Arrays.asList(product));
		order.setNoOfItemsOrdered(requestedQuantity);

		ordersRepository.save(order);
		productService.updateProduct(product);

		return order;
	}


	public List<Orders> getOrderDetailsByCustomerId(int customerId) {
		List<Orders> orders = ordersRepository.findByCustomerCustomerId(customerId);
		if(orders.isEmpty()){
			throw new OrderNotFoundException("Order are not available for given customer id : "+customerId);
		}
		return orders;
	}
}
