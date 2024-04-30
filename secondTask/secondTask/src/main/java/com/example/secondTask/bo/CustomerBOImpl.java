package com.example.secondTask.bo;

import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.secondTask.eo.CustomerEO;
import com.example.secondTask.feignClient.DataRetrieval;
import com.example.secondTask.model.Customer;

@Service
public class CustomerBOImpl implements CustomerBO{

	Logger logger = LoggerFactory.getLogger(CustomerBOImpl.class);
	
	@Autowired
	private CustomerEO custEO;
	
	@Autowired
	private DataRetrieval customerFeign;
	
	@Override
	public Customer[] getCustomersByRestTemplate() throws URISyntaxException {
		
		logger.info("Retrieving all Customers data using Rest template from BO Layer...");
		
		//String url = "http://localhost:8082/sbapp1/retrieval";
		//URI uri = new URI(url);
		RestTemplate restTemplate = custEO.getCustomersByRestTemplate();
		return restTemplate.getForObject("http://localhost:8080/app1/retrieval", Customer[].class);
		
	}

	@Override
	public List<Customer> feignGetAllCustomers() throws URISyntaxException {
		logger.info("Retrieving all Customers data using feign client from BO Layer...");
		List<Customer> customer= customerFeign.getAllCustomers();
		return customer;
	}

}
