package com.example.secondTask.restHelper;

import org.springframework.web.client.RestTemplate;

public interface CustomerRestHelper {
	
	public RestTemplate getCustomersByRestTemplate();
	
}
