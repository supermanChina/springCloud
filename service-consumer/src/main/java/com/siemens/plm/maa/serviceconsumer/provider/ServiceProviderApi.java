package com.siemens.plm.maa.serviceconsumer.provider;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("service-provider")
public interface ServiceProviderApi {
    @GetMapping("/hello")
    String helloUser();
}
