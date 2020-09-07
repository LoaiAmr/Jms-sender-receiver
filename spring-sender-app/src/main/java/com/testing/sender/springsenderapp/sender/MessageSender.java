package com.testing.sender.springsenderapp.sender;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.testing.sender.springsenderapp.model.Product;

@Component
public class MessageSender {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendMessage(final Product product) {

		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				ObjectMessage objectMessage = session.createObjectMessage(product);
				return objectMessage;
			}
		});
	}

}
