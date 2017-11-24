package com.se77.payara.jpa.onetoone;

import com.se77.payara.jpa.onetoone.Entity1;
import com.se77.payara.jpa.onetoone.Entity2;
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
public class OneToOneTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(Entity1.class.getPackage())
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
    public void oneToOneRelationBidirectional(){
        Entity1 ent1 = new Entity1();
        Entity2 ent2 = new Entity2();

        em.persist(ent1);
        em.persist(ent2);

        ent1.setEntity2(ent2);
        ent2.setEntity1(ent1);

        Entity1 result = em.find(Entity1.class, ent1.getId());

        Assert.assertNotNull(result.getEntity2());

        Assert.assertNotNull(result.getEntity2().getEntity1());
    }
}
