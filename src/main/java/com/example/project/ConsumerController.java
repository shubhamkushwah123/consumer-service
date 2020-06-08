package com.example.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

	@Autowired
	public RestTemplate restTemplate;
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String getHello()
	{

		String url = "http://ApplicationService/hello";

		String message = restTemplate.getForObject(url , String.class);
		
		return message;
	}
}
