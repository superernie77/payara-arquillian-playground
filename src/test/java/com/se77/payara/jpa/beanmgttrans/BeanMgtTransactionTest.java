package com.se77.payara.jpa.beanmgttrans;

import com.se77.payara.jpa.onetomany.Entity1;
import com.se77.payara.jpa.onetomany.EntityMany;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionRequiredException;
import javax.transaction.UserTransaction;
import java.util.Arrays;
import java.util.List;

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
