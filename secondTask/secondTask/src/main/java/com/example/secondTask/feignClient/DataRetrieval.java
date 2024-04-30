package com.example.secondTask.feignClient;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.secondTask.model.Customer;

@FeignClient(value="customerFeign", url="http://localhost:8080/app1/retrieval")
public interface DataRetrieval {

	@GetMapping("")
	public List<Customer> getAllCustomers();
	
}
