package com.testing.receiver.springreceiverapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.testing.receiver.springreceiverapp.config.AppConfig;
import com.testing.receiver.springreceiverapp.receiver.MessageReceiver;
import com.testing.sender.springsenderapp.model.Product;

public class MessageConsumerApp {

	public static void main(String[] args) {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		MessageReceiver messageReceiver = (MessageReceiver) context.getBean("messageReceiver");

//		while (true) {
//			Product product = messageReceiver.receiveMessage();
//			System.out.println("Message Received = " + product);
//		}
	}

}
