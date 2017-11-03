package com.se77.payara.ejb.stateless;


import javax.ejb.Stateless;

@Stateless
public class MySessionBean {

    public String syaHello(){
        return "hi!";
    }
}
