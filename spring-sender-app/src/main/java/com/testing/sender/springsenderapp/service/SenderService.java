package com.testing.sender.springsenderapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.testing.sender.springsenderapp.model.Employee;
import com.testing.sender.springsenderapp.model.Product;

@Service
public class SenderService {

	private static final Logger log = LoggerFactory.getLogger(Product.class);

	private final JmsTemplate jmsTemplate;

	public SenderService(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public Product sendProduct(final Product productSended) {
		log.info("Sending a Product...." + productSended);
		jmsTemplate.convertAndSend("message_queue", productSended);
		return productSended;
	}
	
	public Employee sendEmployee(final Employee employeeSended) {
		log.info("Sending an Employee...." + employeeSended);
		jmsTemplate.convertAndSend("message_queue", employeeSended);
		return employeeSended;
	}


}
