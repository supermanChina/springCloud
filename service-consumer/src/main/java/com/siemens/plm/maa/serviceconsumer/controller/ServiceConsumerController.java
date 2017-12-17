package com.siemens.plm.maa.serviceconsumer.controller;

import com.siemens.plm.maa.serviceconsumer.provider.ServiceProviderApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceConsumerController {
    @Autowired
    private ServiceProviderApi serviceProviderApi;
    @GetMapping("/userHello")
    public String consumeHelloUser() {
        return "Consume service by service provided API interface: <br> " + serviceProviderApi.helloUser();
    }
}
