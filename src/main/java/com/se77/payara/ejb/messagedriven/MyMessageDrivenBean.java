package com.se77.payara.ejb.messagedriven;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

// The queue is defined in glassfish-resources.xml config file
@MessageDriven(mappedName = "jms/queue/example")
public class MyMessageDrivenBean implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("Message received: " + message.getBody(String.class));
        } catch (JMSException ex) {
        }

    }
}

