package com.siemens.plm.maa.serviceprovider.controller;

import com.siemens.plm.maa.serviceprovider.domain.ProviderUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceProviderController {
    private static final Logger logger = LoggerFactory.getLogger(ServiceProviderController.class);

    @GetMapping("/users/hello")
    public String helloStringService() {
        logger.info("Receive hello request");
        return "Hello from micro service provider";
    }

    @PostMapping("/users")
    public ResponseEntity<?> postNewUser(@RequestBody ProviderUser user){
        logger.info("Received new user for create: {}", user);
        //TODO: Save new user into DB
        user.setId(2L);
        logger.info("Saved new user: {}", user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
