package com.se77.payara.ejb.remote;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

@RunWith(Arquillian.class)
public class MyRemoteInterfaceTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(MySessionRemoteEjb.class.getPackage());
    }

    @EJB
    private MyRemoteInterface bean;

    @Test
    public void remoteInterfaceTest() {

        Assert.assertNotNull(bean);

        Assert.assertTrue(bean.sayHello().equals("hi!"));
    }

}
