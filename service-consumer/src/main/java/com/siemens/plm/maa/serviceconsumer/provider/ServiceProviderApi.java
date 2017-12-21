package com.siemens.plm.maa.serviceconsumer.provider;

import com.siemens.plm.maa.serviceconsumer.domain.UserForProvider;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("service-provider")
public interface ServiceProviderApi {
    @GetMapping("/users/hello")
    String helloUser();

    @PostMapping("/users/")
    UserForProvider addNewUser(@RequestBody UserForProvider user);
}
