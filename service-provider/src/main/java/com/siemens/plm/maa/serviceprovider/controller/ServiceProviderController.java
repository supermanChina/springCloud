package com.siemens.plm.maa.serviceprovider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceProviderController {
    private static final Logger logger = LoggerFactory.getLogger(ServiceProviderController.class);

    @GetMapping("/hello")
    public String helloStringService() {
        logger.info("Receive hello request");
        return "Hello from micro service provider";
    }
}
