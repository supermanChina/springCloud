package com.siemens.plm.maa.serviceprovider.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.siemens.plm.maa.serviceprovider.domain.ProviderUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.security.Provider;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceProviderControllerTest {


    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testHelloStringService() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.ALL)).andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello from micro service provider")));
    }

    @Test
    public void testPostNewUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/").contentType(MediaType.APPLICATION_JSON_VALUE).content
                (Resources
                        .toString(Resources.getResource("user.json"), Charsets.UTF_8))).andExpect(status().isCreated());
    }
    
    @After
    public void tearDown() throws Exception {

    }
}