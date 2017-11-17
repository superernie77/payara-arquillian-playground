package com.se77.payara.jpa.beanmgttrans;

import com.se77.payara.jpa.onetoone.Entity2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@javax.persistence.Entity
public class EntityBM {

    @Id
    @GeneratedValue
    private Long id;

    private Entity2 entity2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
