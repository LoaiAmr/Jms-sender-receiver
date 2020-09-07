package com.testing.receiver.springreceiverapp.receiver;

import javax.jms.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.testing.sender.springsenderapp.model.Product;

@Component
public class MessageReceiver {

//	@Autowired
//	private JmsTemplate jmsTemplate;
//
//	@Autowired
//	private MessageConverter messageConverter;
//
//	public Product receiveMessage() {
//		try {
//			/*
//			 * Here we receive the message.
//			 */
//			Message message = jmsTemplate.receive();
//			Object o = messageConverter.fromMessage(message);
//			Product product = (Product) o;
//			return product;
//
//		} catch (Exception exe) {
//			exe.printStackTrace();
//		}
//
//		return null;
//	}

	private static final Logger log = LoggerFactory.getLogger(MessageReceiver.class);

	private int count = 1;

	@JmsListener(destination = "message_queue")
	public void receiveMessage(Product productReceiver) {
		log.info("<" + count + "> Received <" + productReceiver + ">");
		count++;
	}

}
