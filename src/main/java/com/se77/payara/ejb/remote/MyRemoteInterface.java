package com.se77.payara.ejb.remote;

import javax.ejb.Remote;

@Remote
public interface MyRemoteInterface {

    String sayHello();
}
