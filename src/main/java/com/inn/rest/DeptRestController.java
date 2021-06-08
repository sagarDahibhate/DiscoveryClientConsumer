package com.inn.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class DeptRestController {

	@Autowired
	private EmployeeRestConsumer consumer;
	
	@GetMapping("/info")
	public ResponseEntity<String> getmsg(){
		String data=consumer.getMsg();
		String body=" from dept app "+data;
		return ResponseEntity.ok(body);
	}
}
