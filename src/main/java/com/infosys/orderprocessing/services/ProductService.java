package com.infosys.orderprocessing.services;

import com.infosys.orderprocessing.entities.Customer;
import com.infosys.orderprocessing.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infosys.orderprocessing.entities.Product;
import com.infosys.orderprocessing.repositories.ProductRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;


	public Product createProduct(Product product) {
		//validate product
		return productRepository.save(product);
	}

	public Product getProductById(int productId) {
		return productRepository.findById(productId)
				.orElseThrow(() ->new ProductNotFoundException("Product is not found with given id : "+productId));
	}

	public List<Product> getAllProducts(){
		List<Product> products = productRepository.findAll();
		if(products.isEmpty()){
			throw  new ProductNotFoundException("Products are not exist OR not yet created.");
		}
		return products;
	}

	public void updateProduct(Product product){
		productRepository.save(product);
	}

	public List<Product> getProductsByIds(int [] ids){
		List<Product> products = productRepository.findByProductIdIn(ids);
		if(products.isEmpty()){
			throw new ProductNotFoundException("Products are not found with given Ids :"+
					Arrays.stream(ids).mapToObj(String::valueOf).reduce((s1, s2) -> s1 +","+s2));
		}
		return products;
	}
}
