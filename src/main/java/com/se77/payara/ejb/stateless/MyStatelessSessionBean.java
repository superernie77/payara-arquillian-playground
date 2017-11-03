package com.se77.payara.ejb.stateless;


import javax.ejb.Stateless;

@Stateless
class MyStatelessSessionBean {

    String syaHello(){
        return "hi!";
    }
}
