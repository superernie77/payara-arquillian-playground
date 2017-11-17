package com.se77.payara.jpa.beanmgttrans;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class SessionBean {

    @Resource
    private UserTransaction ut;


    @PersistenceContext
    private EntityManager em;

    public EntityBM createNewEntity() throws Exception{
        ut.begin();

        EntityBM entity = new EntityBM();
        em.persist(entity);

        ut.commit();

        return entity;
    }

    public EntityBM createNewEntityWithExcption() throws Exception{
        EntityBM entity = new EntityBM();
        em.persist(entity);
        return entity;
    }


}
