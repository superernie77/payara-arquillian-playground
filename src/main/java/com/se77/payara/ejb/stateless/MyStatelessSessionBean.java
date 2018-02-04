package com.se77.payara.ejb.stateless;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

@Stateless
public class MyStatelessSessionBean {

    @PostConstruct
    public void postConstruct(){
        System.out.println("PostConstruct method called: "+this);

    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("PreDestroy method called: "+this);
    }

    public String sayHello(){
        return "hi!";
    }
}
