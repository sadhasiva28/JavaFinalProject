package com.mph.inher;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class  MainClass {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
        Traveller service =(Traveller)context.getBean("traveller");
        service.startVehicle();
    }
}
