package com.se77.payara.ejb.remote;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
public class MyStatelessBean implements MyRemoteInterface {

    public String sayHello(){
        return "hi!";
    }
}
