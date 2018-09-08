package com.xiang.manager;

import com.xiang.swagger.EnableCusSwagger;
import com.xiang.swagger.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;

/**
 * swagger使用方法：
 * 1、导入方式:@Import(SwaggerConfiguration.class)
 * 2、使用自定义注解：@EnableCusSwagger
 * 3、通过spring.factories自动扫描配置
 */
@SpringBootApplication
@EntityScan("com.xiang.entity")
public class ManagerApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(ManagerApp.class,args);
    }
}
