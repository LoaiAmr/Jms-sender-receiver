package com.testing.sender.springsenderapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class SpringSenderAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSenderAppApplication.class, args);
	}

}
