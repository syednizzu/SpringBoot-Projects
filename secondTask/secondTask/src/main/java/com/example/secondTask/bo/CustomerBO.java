package com.example.secondTask.bo;

import java.net.URISyntaxException;
import java.util.List;

import com.example.secondTask.model.Customer;

public interface CustomerBO {
	
	public Customer[] getCustomersByRestTemplate() throws URISyntaxException;
	
	public List<Customer> feignGetAllCustomers() throws URISyntaxException;

}
