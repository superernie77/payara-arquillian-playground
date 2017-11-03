package com.se77.payara.ejb.stateful;

import javax.ejb.Stateful;

@Stateful
public class MyStatefulBean {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
