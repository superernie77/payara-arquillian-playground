package com.se77.payara.jpa.events;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class CallbackListener {
	
	@PrePersist
	public void userPrePersist(EntityWithListener ob) {
		System.out.println("Listening EntityWithListener Pre Persist : " + ob.getId());
	}
	@PostPersist
	public void userPostPersist(EntityWithListener ob) {
		System.out.println("Listening EntityWithListener Post Persist : " + ob.getId());
	}
	@PostLoad
	public void userPostLoad(EntityWithListener ob) {
		System.out.println("Listening EntityWithListener Post Load : " + ob.getId());
	}	
	@PreUpdate
	public void userPreUpdate(EntityWithListener ob) {
		System.out.println("Listening EntityWithListener Pre Update : " + ob.getId());
	}
	@PostUpdate
	public void userPostUpdate(EntityWithListener ob) {
		System.out.println("Listening EntityWithListener Post Update : " + ob.getId());
	}
	@PreRemove
	public void userPreRemove(EntityWithListener ob) {
		System.out.println("Listening EntityWithListener Pre Remove : " + ob.getId());
	}
	@PostRemove
	public void userPostRemove(EntityWithListener ob) {
		System.out.println("Listening EntityWithListener Post Remove : " + ob.getId());
	}

}
