package com.se77.payara.ejb.intercept;


import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

@Stateful
@LocalBean
public class InterceptedStatefulBean {

    private int hiCounter = 0;

    @PostConstruct
    public void postConstruct(){
        System.out.println("postConstruct called for: "+this);
        System.out.println("hiCounter: "+this.hiCounter);
    }

    public int getHiCounter(){
        return hiCounter;
    }


    @AroundInvoke
    public Object incrementCounter(InvocationContext context) throws Exception {
        if (context.getMethod().getName().equals("sayHi")){
            hiCounter++;
        }

        return context.proceed();
    }

    public String sayHi(){
        return "hi!";
    }
}
