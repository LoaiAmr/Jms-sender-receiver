package com.testing.sender.springsenderapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.testing.sender")
@Import({ MessagingConfiguration.class })
public class AppConfig {

	// Put Other Application configuration here.
}
