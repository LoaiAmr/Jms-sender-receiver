package com.testing.sender.springsenderapp;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.testing.sender.springsenderapp.config.AppConfig;
import com.testing.sender.springsenderapp.model.Product;
import com.testing.sender.springsenderapp.sender.MessageSender;


public class MessageProducerApp {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		MessageSender messageSender = context.getBean(MessageSender.class);

		Scanner sc = new Scanner(System.in);

		while (!sc.equals("Exit")) {

			System.out.println("Please Enter The Product ID: ");
			int id = Integer.parseInt(sc.nextLine());

			System.out.println("Please Enter The Product Name: ");
			String name = sc.nextLine();

			System.out.println("Please Enter The Product Quantity: ");
			int quantity = Integer.parseInt(sc.nextLine());

			Product product = new Product();
			product.setProductId(id);
			product.setName(name);
			product.setQuantity(quantity);

			messageSender.sendMessage(product);
			System.out.println("Message has been sent successfully...");

		}

	}

}
