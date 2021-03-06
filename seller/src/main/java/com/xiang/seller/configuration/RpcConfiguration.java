package com.xiang.seller.configuration;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcClientProxyCreator;
import com.xiang.api.ProductRpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 迁移jsonrpc模块，使用rpc自动配置
 * rpc相关配置
 * @author guixiang
 * @date 2018-09-09
 */
/*@Configuration
public class RpcConfiguration
{
    private static Logger LOG = LoggerFactory.getLogger(RpcConfiguration.class);

    @Bean
    public AutoJsonRpcClientProxyCreator rpcClientProxyCreator(@Value("${rpc.manager.url}")String url)
    {
        AutoJsonRpcClientProxyCreator creator = new AutoJsonRpcClientProxyCreator();
        try
        {
            creator.setBaseUrl(new URL(url));
        }
        catch (MalformedURLException e)
        {
            LOG.error("创建rpc服务地址错误",e);
        }
        //扫描接口
        creator.setScanPackage(ProductRpc.class.getPackage().getName());
        return creator;
    }
}*/
