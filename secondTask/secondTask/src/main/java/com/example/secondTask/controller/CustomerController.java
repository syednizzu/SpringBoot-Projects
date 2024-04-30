package com.example.secondTask.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.secondTask.model.Customer;
import com.example.secondTask.service.CustomerService;
import com.example.secondTask.service.CustomerServiceImpl;


@RestController
@RequestMapping("/app2")
public class CustomerController {
	
	Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerServiceImpl custService;
	
	
	@GetMapping("/hello")
	public String hello() {
	    return "Hello from Second Application...";
	}
	
	@GetMapping("/getCustomers")
	public ResponseEntity<Customer[]> getAllStudents() throws URISyntaxException{
		logger.info("Retrieving all Customers data using Rest template from Controller...");
		return new ResponseEntity(custService.getCustomersByRestTemplate(), HttpStatus.OK);
	}
	
	
	@GetMapping("/feignGetCustomers")
	public ResponseEntity<List<Customer>> feignGetAllStudents() throws URISyntaxException{
		logger.info("Retrieving all Customers data using feign client from Controller...");
		return new ResponseEntity(custService.feignGetAllCustomers(), HttpStatus.OK);
	}

}
