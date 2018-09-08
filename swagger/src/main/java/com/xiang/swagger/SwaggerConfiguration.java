package com.xiang.swagger;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置类
 * @author guixiang
 * @date 2018-09-08
 */
@Configuration
@ComponentScan(basePackages = "com.xiang.swagger")
@EnableSwagger2
public class SwaggerConfiguration
{
    @Autowired
    private SwaggerInfo swaggerInfo;
    @Bean
    public Docket controllerApi()
    {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName(swaggerInfo.getGroupName())
                .apiInfo(aipInfo());
        ApiSelectorBuilder builder = docket.select();
        if(!StringUtils.isEmpty(swaggerInfo.getBasePackage()))
        {
            builder = builder.apis(RequestHandlerSelectors.basePackage(swaggerInfo.getBasePackage()));
        }
        if(!StringUtils.isEmpty(swaggerInfo.getAntPath()))
        {
            builder = builder.paths(PathSelectors.ant(swaggerInfo.getAntPath()));
        }
        return builder.build();
    }

    @Bean
    public Docket defaultApi()
    {
        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("controller")
//                .apiInfo(aipInfo())
                .select().apis(RequestHandlerSelectors.basePackage(BasicErrorController.class.getPackage().getName()))
//                .paths(PathSelectors.ant("/products/"))
                .build();

    }

    private ApiInfo aipInfo()
    {
        return new ApiInfoBuilder()
                .title(swaggerInfo.getTitle())
                .description(swaggerInfo.getDescription())
                .termsOfServiceUrl("http://springfox.io")
                .contact("xiang")
                .license(swaggerInfo.getAntPath())
                .licenseUrl("https://github.com/springfox/springfox/blob")
                .version("2.0")
                .build();
    }
}
