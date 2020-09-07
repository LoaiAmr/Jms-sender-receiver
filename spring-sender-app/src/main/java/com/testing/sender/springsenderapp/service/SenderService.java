package com.testing.sender.springsenderapp.service;

import org.springframework.stereotype.Service;

import com.testing.sender.springsenderapp.model.Product;
import com.testing.sender.springsenderapp.sender.MessageSender;

@Service
public class SenderService {

	public Product sendProduct(final Product productSended) {
		MessageSender messageSender = new MessageSender();
		messageSender.sendMessage(productSended);
		return productSended;
	}

}
