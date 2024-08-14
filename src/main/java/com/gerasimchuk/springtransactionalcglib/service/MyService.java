package com.gerasimchuk.springtransactionalcglib.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

// assume that it will be CGLIB-proxied
@Service
public class MyService {


    @Transactional(propagation = Propagation.REQUIRED)
    public void doSmth() {
        System.out.println("In method doSmth " + this.getClass().getName());
        System.out.println("Calling doSmthElse");
        doSmthElse();
        System.out.println("End of doSmth method");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void doSmthElse() {
        System.out.println("In method doSmthElse " + this.getClass().getName());
    }

}
