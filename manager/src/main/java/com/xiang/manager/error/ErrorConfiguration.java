package com.xiang.manager.error;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 错误处理相关配置
 * Author:guixiang
 * Date:2018-09-06
 */
@Configuration
public class ErrorConfiguration
{
    @Bean
    public CustomErrorController basicErrorController(ErrorAttributes errorAttributes,ServerProperties serverProperties,ObjectProvider<List<ErrorViewResolver>> errorViewResolversProvider) {
        return new CustomErrorController(errorAttributes, serverProperties.getError(),
                errorViewResolversProvider.getIfAvailable());
    }
}
