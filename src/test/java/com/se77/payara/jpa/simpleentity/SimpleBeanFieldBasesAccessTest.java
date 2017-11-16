package com.se77.payara.jpa.simpleentity;

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

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

@RunWith(Arquillian.class)
public class SimpleBeanFieldBasesAccessTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(SimpleBeanFieldBasedAccess.class.getPackage())
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Before
    public void preparePersistenceTest() throws Exception {
        utx.begin();
        em.joinTransaction();
    }

    @After
    public void commitTransaction() throws Exception {
        utx.commit();
    }

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    @Test
    public void saveAndGet(){
        SimpleBeanFieldBasedAccess bean = new SimpleBeanFieldBasedAccess();
        bean.setProperty1("test");

        em.persist(bean);
        SimpleBeanFieldBasedAccess result = em.find(SimpleBeanFieldBasedAccess.class, bean.getId());

        Assert.assertNotNull(result);

    }
}
