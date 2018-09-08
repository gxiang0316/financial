package com.xiang.manager.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置类
 * @author guixiang
 * @date 2018-09-08
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration
{
    @Bean
    public Docket controllerApi()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("controller")
                .apiInfo(aipInfo())
                .select()
                .build();

    }

    private ApiInfo aipInfo()
    {
        return new ApiInfoBuilder()
                .title("HTTP API")
                .description("管理端接口")
                .termsOfServiceUrl("http://springfox.io")
                .contact("xiang")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/springfox/springfox/blob")
                .version("2.0")
                .build();
    }
}
