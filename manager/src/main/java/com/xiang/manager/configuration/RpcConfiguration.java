package com.xiang.manager.configuration;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImplExporter;
import com.xiang.api.ProductRpc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * rpc相关配置
 * @author guixiang
 * @date 2018-09-09
 */
@Configuration
@ComponentScan(basePackageClasses = {ProductRpc.class})
public class RpcConfiguration
{
    @Bean
    public AutoJsonRpcServiceImplExporter rpcServiceImplExporter()
    {
        return new AutoJsonRpcServiceImplExporter();
    }
}
