package com.example.secondTask.service;

import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.secondTask.bo.CustomerBO;
import com.example.secondTask.bo.CustomerBOImpl;
import com.example.secondTask.controller.CustomerController;
import com.example.secondTask.model.Customer;

@Component
public class CustomerServiceImpl implements CustomerService {

	Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerBOImpl custBO;
	
	public Customer[] getCustomersByRestTemplate() throws URISyntaxException {
		logger.info("Retrieving all Customers data using Rest template from Service Layer...");
		return custBO.getCustomersByRestTemplate();
	}
	
	
	public List<Customer> feignGetAllCustomers() throws URISyntaxException{
		logger.info("Retrieving all Students data using feign client from Service Layer...");
		List<Customer> customers= custBO.feignGetAllCustomers();
		return customers;
	}
	
}
