package com.se77.payara.ejb.stateful;


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
public class MyStatefulSessionBeanTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(MyStatefulSessionBean.class.getPackage());
    }

    @EJB
    private MyStatefulSessionBean bean;

    @Test
    public void testStatefulBean(){

        Assert.assertNotNull(bean);

        bean.setState("mystate");

        Assert.assertTrue(bean.getState().equals("mystate"));

    }
}
