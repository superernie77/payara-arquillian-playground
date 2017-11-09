package com.se77.payara.ejb.remote;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
public class MySessionRemoteEjb implements MyRemoteInterface {

    public String sayHello(){
        return "hi!";
    }
}
