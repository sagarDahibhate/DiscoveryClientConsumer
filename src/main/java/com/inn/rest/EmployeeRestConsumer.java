package com.inn.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EmployeeRestConsumer {

	@Autowired
	private DiscoveryClient client;
	
	public String getMsg() {
		List<ServiceInstance> list=client.getInstances("EMPLOYEE-APP");
		ServiceInstance si=list.get(0);
		URI uri = si.getUri();
		String url = uri + "/producer/show";
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> resp=rt.getForEntity(url, String.class);
		return resp.getBody();
	}
}
