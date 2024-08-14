package com.gerasimchuk.springtransactionalcglib;

import com.gerasimchuk.springtransactionalcglib.service.MyService;
import com.gerasimchuk.springtransactionalcglib.util.SpringCglibUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringTransactionalCglibApplication {


    private static final String GENERATED_CLASS_FILES = "C:\\Users\\reaper\\IdeaProjects\\work\\kptv\\spring-transactional-cglib\\generated_files";
    private static MyService myService;

    public static void main(String[] args) {

        SpringCglibUtils.initGeneratedClassHandler(GENERATED_CLASS_FILES);
        SpringApplication.run(SpringTransactionalCglibApplication.class, args);

        System.out.println("MyService: " + myService.getClass());


        myService.doSmth();


        System.out.println("Run successfully");
    }

    @Autowired
    public void setMyService(MyService myService) {
        SpringTransactionalCglibApplication.myService = myService;
    }
}
