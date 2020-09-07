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

import com.testing.sender.springsenderapp.model.Product;
import com.testing.sender.springsenderapp.service.SenderService;

@RestController
@RequestMapping("/activemq")
@CrossOrigin
public class SenderController {

	private static final Logger log = LoggerFactory.getLogger(Product.class);

	@Autowired
	private SenderService senderService;

	private final JmsTemplate jmsTemplate;

	public SenderController(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	@PostMapping("/send-product")
	public ResponseEntity<Product> sendProduct(@RequestBody final Product productSended) {

		Product product = senderService.sendProduct(productSended);
		return ResponseEntity.ok(productSended);
	}

	@PostMapping("/send")
	public ResponseEntity<Object> send(@RequestBody Product productSended) {
		log.info("Sending a Product...." + productSended);
		 jmsTemplate.convertAndSend("message_queue", productSended);
		return ResponseEntity.ok(productSended);

	}

}
