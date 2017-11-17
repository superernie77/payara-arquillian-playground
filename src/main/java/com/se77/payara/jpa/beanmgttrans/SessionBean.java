package com.se77.payara.jpa.beanmgttrans;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.List;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class SessionBean {

    @Resource
    private UserTransaction ut;


    @PersistenceContext
    private EntityManager em;

    public Entity1 createNewEntity() throws Exception{
        ut.begin();

        Entity1 entity = new Entity1();
        em.persist(entity);

        ut.commit();

        return entity;
    }

    public Entity1 createNewEntityWithExcption() throws Exception{
        Entity1 entity = new Entity1();
        em.persist(entity);
        return entity;
    }


}
