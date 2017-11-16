package com.se77.payara.jpa.simpleentity;

import javax.persistence.*;

@Entity
@Access(AccessType.FIELD)
public class SimpleBeanFieldBasedAccess {

    @Id @GeneratedValue
    private Long id;

    private String property1;

    public Long getId() {
        return id;
    }

    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }
}
