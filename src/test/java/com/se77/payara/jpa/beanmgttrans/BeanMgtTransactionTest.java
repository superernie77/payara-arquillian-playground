package com.se77.payara.jpa.beanmgttrans;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.ejb.EJBException;

@RunWith(Arquillian.class)
public class BeanMgtTransactionTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(SessionBean.class.getPackage())
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

   @EJB
   private SessionBean sessionBean;


   @Test
   public void testBeanMgtTransaction() throws Exception{
         Assert.assertNotNull(sessionBean.createNewEntity());
     }

    @Test(expected = EJBException.class)
    public void testBeanMgtTransException() throws Exception{
        sessionBean.createNewEntityWithExcption();
    }
}
