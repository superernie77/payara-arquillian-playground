package com.se77.payara.jpa.containermgttrans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SessionBean {

    @PersistenceContext
    private EntityManager em;

    public Entity1 createNewEntity() throws Exception{
        Entity1 entity = new Entity1();
        em.persist(entity);
        return entity;
    }
}
