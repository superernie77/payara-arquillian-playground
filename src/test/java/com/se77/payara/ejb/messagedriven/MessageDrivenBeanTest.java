package com.se77.payara.ejb.messagedriven;

import com.se77.payara.ejb.remote.MyRemoteInterface;
import com.se77.payara.ejb.remote.MySessionRemoteEjb;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jms.*;

@RunWith(Arquillian.class)
public class MessageDrivenBeanTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(MyMessageDrivenBean.class.getPackage());
    }

    /**
     * Resource is defined in glassfish-resource.xml config file
     */
   @Resource(mappedName = "jms/ConnectionFactory", name = "jms/ConnectionFactory")
   private ConnectionFactory connectionFactory;

    /**
     * Resource is defined in glassfish-resource.xml config file
     */
    @Resource(mappedName = "jms/queue/example", name = "jms/queue/example")
    private Queue queue;


    @Test
    public void sendMessgage() throws Exception {
        System.out.println("Sending message ...");

        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(queue);

        TextMessage textMessage = session.createTextMessage("Hello world!");
        producer.send(textMessage);
        session.close();
        connection.close();
    }
}
