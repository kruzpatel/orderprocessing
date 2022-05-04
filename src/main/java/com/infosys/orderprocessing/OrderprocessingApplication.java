package com.infosys.orderprocessing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class OrderprocessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderprocessingApplication.class, args);
	}

}
