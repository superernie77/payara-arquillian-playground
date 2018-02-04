package com.se77.payara.jpa.onetomany;

import javax.persistence.*;
import java.util.List;

@Entity
public class EntityOne {

    @Id
    @GeneratedValue
    private Long id;

    // the field one of entity EntityMany defines the relationship.
    // EntityMany has a table with column EntityQ-ID
    @OneToMany(mappedBy = "one", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<EntityMany> manies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<EntityMany> getManies() {
        return manies;
    }

    public void setManies(List<EntityMany> manies) {
        this.manies = manies;
    }
}
