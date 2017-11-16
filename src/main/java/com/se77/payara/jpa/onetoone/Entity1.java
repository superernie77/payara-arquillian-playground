package com.se77.payara.jpa.onetoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Entity1 {

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

    public Entity2 getEntity2() {
        return entity2;
    }

    public void setEntity2(Entity2 entity2) {
        this.entity2 = entity2;
    }
}
