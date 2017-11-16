package com.se77.payara.jpa.onetomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EntityMany {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Entity1 one;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Entity1 getOne() {
        return one;
    }

    public void setOne(Entity1 one) {
        this.one = one;
    }
}
