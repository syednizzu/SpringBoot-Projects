package com.example.secondTask.service;

import java.net.URISyntaxException;
import java.util.List;
import com.example.secondTask.model.Customer;

public interface CustomerService {
	
	public Customer[] getCustomersByRestTemplate() throws URISyntaxException;
	
	public List<Customer> feignGetAllCustomers() throws URISyntaxException;
}
