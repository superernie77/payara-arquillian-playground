package com.se77.payara.ejb.stateful;


import com.se77.payara.ejb.stateless.MySessionBean;
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
public class MyStatefulBeanTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(MyStatefulBean.class.getPackage());
    }

    @EJB
    private MyStatefulBean bean;

    @Test
    public void testStatefulBean(){

        Assert.assertNotNull(bean);

        bean.setState("mystate");

        Assert.assertTrue(bean.getState().equals("mystate"));

    }
}
