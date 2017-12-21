package com.siemens.plm.maa.serviceconsumer.controller;

import com.siemens.plm.maa.serviceconsumer.domain.UserForProvider2;
import com.siemens.plm.maa.serviceconsumer.provider.ServiceProviderApi2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceConsumer2Controller {
    private static final Logger logger = LoggerFactory.getLogger(ServiceConsumer2Controller.class);
    @Autowired
    private ServiceProviderApi2 serviceProviderApi;
    @GetMapping("/userHello")
    public String consumeHelloUser() {
        return "Consume service by service provided API interface: <br> " + serviceProviderApi.helloUser();
    }

    @PostMapping("/consume/userAdd")
    public UserForProvider2 createUser(@RequestBody UserForProvider2 user){
        UserForProvider2 newUser = serviceProviderApi.addNewUser(user);
        logger.info("New user added: {}", newUser);
        return newUser;
    }
}
