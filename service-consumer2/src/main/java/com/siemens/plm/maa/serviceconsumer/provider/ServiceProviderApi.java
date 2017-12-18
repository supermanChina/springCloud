package com.siemens.plm.maa.serviceconsumer.provider;

import com.siemens.plm.maa.serviceconsumer.domain.UserForProvider2;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("service-provider")
public interface ServiceProviderApi {
    @GetMapping("/hello")
    String helloUser();

    @PostMapping("/users/")
    UserForProvider2 addNewUser(@RequestBody UserForProvider2 user);
}
