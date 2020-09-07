package com.testing.receiver.springreceiverapp.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.testing.sender.springsenderapp.model.ParentMessage;

@Component
public class MessageReceiver {

	private static final Logger log = LoggerFactory.getLogger(MessageReceiver.class);

	private int count = 1;

	@JmsListener(destination = "message_queue")
	public void receiveMessage(ParentMessage objectReceiver) {
		log.info("<" + count + "> Received <" + objectReceiver + ">");
		count++;
	}

}
