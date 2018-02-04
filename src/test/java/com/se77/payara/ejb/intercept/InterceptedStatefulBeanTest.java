package com.se77.payara.ejb.intercept;

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
public class InterceptedStatefulBeanTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(InterceptedStatefulBean.class.getPackage());
    }

    @EJB
    private InterceptedStatefulBean bean;

    @Test
    public void remoteInterfaceTest() {
        Assert.assertNotNull(bean);

        bean.sayHi();
        bean.sayHi();
        bean.sayHi();

        Assert.assertTrue(bean.getHiCounter() == 3);
    }
}
