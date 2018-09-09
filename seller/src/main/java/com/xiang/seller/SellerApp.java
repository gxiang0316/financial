package com.xiang.seller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 销售端启动类
 * @author guixiang
 * @date 2018-09-09
 */
@SpringBootApplication
@EnableCaching
public class SellerApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(SellerApp.class);
    }
}
