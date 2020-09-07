package com.testing.receiver.springreceiverapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.testing")
@Import({ MessagingConfiguration.class })
public class AppConfig {

	// Put Other Application configuration here.
}
