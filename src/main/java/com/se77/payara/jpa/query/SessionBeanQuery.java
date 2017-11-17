package com.se77.payara.jpa.query;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SessionBeanQuery {

    @PersistenceContext
    private EntityManager em;

    public void createNewEntity(int number) throws Exception {
        for (int i = 0 ; i < number ;i++) {
            em.persist(new EntityQ());
        }
    }

    public List<EntityQ> getAllEntities(){
        Query q = em.createQuery("SELECT e FROM EntityQ e ");
        return q.getResultList();
    }
}
