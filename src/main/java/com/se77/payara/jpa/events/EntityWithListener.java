package com.se77.payara.jpa.events;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@EntityListeners(CallbackListener.class)
public class EntityWithListener {
	

    @Id
    @GeneratedValue
    private Long id;
    
    private String property;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

}
