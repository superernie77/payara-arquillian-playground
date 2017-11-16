package com.se77.payara.jpa.simpleentity;

import javax.persistence.*;

@Entity
@Access(AccessType.PROPERTY)
public class SimpleBeanPropertyAccess {


    private Long id;

    // This is created as a varchar in the DB
    private String property1;

    @Lob // this is created as a CLOB-Field in the DB
    private String property2;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }
}
