package com.testing.sender.springsenderapp.receiver;

import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.testing.sender.springsenderapp.model.Product;

@Component
public class MessageReceiver {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private MessageConverter messageConverter;

	public Product receiveMessage() {
		try {
			/*
			 * Here we receive the message.
			 */
			Message message = jmsTemplate.receive();
			Product product = (Product) messageConverter.fromMessage(message);
			return product;

		} catch (Exception exe) {
			exe.printStackTrace();
		}

		return null;
	}
}
