package com.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Address;
import com.ecommerce.repository.AddddRepo;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@RestController
public class EcommerceApplication {
//@Autowired
//AddddRepo er;
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	/*
	 * @Bean CommandLineRunner run(){ Address address = new Address();
	 * address.setId("123"); address.setAddress("Dehugaon");
	 * address.setAddressType(1); address.setIsDefault(true);
	 * address.setUserId("402881f273c8a6210173c8a8352e0000");
	 * address.setPinCode(412109);
	 * 
	 * er.save(address); return null; }
	 */
}
