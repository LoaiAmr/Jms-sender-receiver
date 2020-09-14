package com.testing.sender.springsenderapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.testing.sender.springsenderapp.dto.SwiftDto;
import com.testing.sender.springsenderapp.dto.SwiftMapper;
import com.testing.sender.springsenderapp.exception.SwiftException;
import com.testing.sender.springsenderapp.model.Employee;
import com.testing.sender.springsenderapp.model.Product;
import com.testing.sender.springsenderapp.model.Swift;

@Service
public class SenderService {

	private static final Logger log = LoggerFactory.getLogger(SenderService.class);

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

	public Swift sendSwift(final SwiftDto swiftDto) throws SwiftException {
		
		boolean isValidSwift = ValidationSwift.checkValidateSwiftCode(swiftDto.getSwiftCode());
		log.info("isValidSwift...." + isValidSwift);
		
		if (isValidSwift) {
			Swift swift = SwiftMapper.convertToSwift(swiftDto);
			log.info("Sending an Swift...." + swiftDto);
			jmsTemplate.convertAndSend("message_queue", swift);
			return swift;
		} else
			return null;
	}

}
