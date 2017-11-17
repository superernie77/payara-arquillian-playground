package com.se77.payara.jpa.query;

import com.se77.payara.jpa.beanmgttrans.SessionBean;
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
public class JpqlQueryTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(EntityQ.class.getPackage())
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

   @EJB
   private SessionBeanQuery sessionBean;


   @Test
   public void testBeanMgtTransaction() throws Exception {

       sessionBean.createNewEntity(3);

       Assert.assertTrue(sessionBean.getAllEntities().size() == 3);
   }
}
