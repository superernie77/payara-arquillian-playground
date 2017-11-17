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

    public EntityC createNewEntity() throws Exception{
        EntityC entity = new EntityC();
        em.persist(entity);
        return entity;
    }
}
