package com.xiang.manager.controller;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest
{
    private static RestTemplate rest = new RestTemplate();

    @Value("http://localhost:${local.server.port}/manager")
    private String baseUrl;


    @Test
    public void create()
    {

    }
}
