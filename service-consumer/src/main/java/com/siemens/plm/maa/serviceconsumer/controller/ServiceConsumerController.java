package com.siemens.plm.maa.serviceconsumer.controller;

import com.siemens.plm.maa.serviceconsumer.domain.UserForProvider;
import com.siemens.plm.maa.serviceconsumer.provider.ServiceProviderApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceConsumerController {
    private static final Logger logger = LoggerFactory.getLogger(ServiceConsumerController.class);
    @Autowired
    private ServiceProviderApi serviceProviderApi;
    @GetMapping("/consume/userHello")
    public String consumeHelloUser() {
        logger.info("Consume hello from provider.");
        return "Consume service by service provided API interface: <br> " + serviceProviderApi.helloUser();
    }

    @PostMapping("/consume/userAdd")
    public UserForProvider createUser(@RequestBody UserForProvider user){
        UserForProvider newUser = serviceProviderApi.addNewUser(user);
        logger.info("New user added: {}", newUser);
        return newUser;
    }
}
