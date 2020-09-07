package com.testing.sender.springsenderapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testing.sender.springsenderapp.model.Employee;
import com.testing.sender.springsenderapp.model.ParentMessage;
import com.testing.sender.springsenderapp.model.Product;
import com.testing.sender.springsenderapp.service.SenderService;

@RestController
@RequestMapping("/activemq")
@CrossOrigin
public class SenderController {

	@Autowired
	private SenderService senderService;

	@PostMapping("/send-product")
	public ResponseEntity<ParentMessage> sendProduct(@RequestBody Product productSended) {
		Product product = senderService.sendProduct(productSended);
		return ResponseEntity.ok(product);

	}
	
	@PostMapping("/send-emp")
	public ResponseEntity<ParentMessage> sendEmployee(@RequestBody Employee empSended) {
		Employee employee = senderService.sendEmployee(empSended);
		return ResponseEntity.ok(employee);
		
	}

}
