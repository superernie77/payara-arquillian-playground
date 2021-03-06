package com.se77.payara.jpa.onetomany;

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
import java.util.Arrays;
import java.util.List;

@RunWith(Arquillian.class)
public class OneToManyTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(EntityMany.class.getPackage())
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
        EntityOne ent1 = new EntityOne();
        EntityMany many1 = new EntityMany();
        EntityMany many2 = new EntityMany();

        List<EntityMany> list = Arrays.asList(many1,many2);

        // create entities
        em.persist(ent1);
        em.persist(many1);
        em.persist(many2);

        // connect entities
        many1.setOne(ent1);
        many2.setOne(ent1);
        ent1.setManies(list);

        EntityOne result = em.find(EntityOne.class, ent1.getId());

        Assert.assertNotNull(result.getManies().size() == 2);
    }

    @Test
    public void testcascadeDelete() throws Exception{
        EntityOne ent1 = new EntityOne();
        EntityMany many1 = new EntityMany();
        EntityMany many2 = new EntityMany();

        List<EntityMany> list = Arrays.asList(many1,many2);

        // create entities
        em.persist(ent1);
        em.persist(many1);
        em.persist(many2);

        // connect entities
        many1.setOne(ent1);
        many2.setOne(ent1);
        ent1.setManies(list);

        utx.commit(); // write all to DB

        // start new transaction
        utx.begin();
        em.joinTransaction();

        EntityOne result = em.find(EntityOne.class, ent1.getId());

        // delete entire tree
        em.remove(result);

        // Child entities are deleted too
        Assert.assertNull(em.find(EntityMany.class,many1.getId()));




    }
}
