package com.se77.payara.ejb.stateful;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
public class MyStatefulSessionBean {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("postConstruct method called: "+this);

    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("preDestroy method called: "+this);
    }

    @PrePassivate
    public void prePassivate(){
        System.out.println("prePassivate method called: "+this);
    }

    @PostActivate
    public void postActivate(){
        System.out.println("postActivate method called: "+this);
    }

    @Remove
    public void remove(){
        System.out.println("Remove method called: "+this);
    }
}
