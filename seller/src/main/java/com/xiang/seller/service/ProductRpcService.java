package com.xiang.seller.service;

import com.xiang.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 产品服务
 * @author guixiang
 * @date 2018-09-09
 */
@Service
public class ProductRpcService implements ApplicationListener<ContextRefreshedEvent>
{
    private static Logger LOG = LoggerFactory.getLogger(ProductRpcService.class);

    @Autowired ProductCache cache;

    /**
     * 查询全部产品
     * @return
     */
    @Bean
    public List<Product> findAll()
    {
        return cache.readAllCache();
    }

    /**
     * 查询单个产品
     * @param id
     * @return
     */
    public Product findOne(String id)
    {
        LOG.info("查询单个产品，参数：{}",id);
        Product product = cache.readCache(id);
        //避免缓存中出现空数据
        if(null == product)
        {
            cache.removeCache(id);
        }
        LOG.info("查询单个产品，结果：{}",product);
        return product;
    }

    /**
     * 测试，此注解在服务启动之后便会调用此方法
     */
    @PostConstruct
    public void testFindAll()
    {
        findAll();
    }

    /**
     * 服务启动缓存数据
     * @param event
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        List<Product> products = findAll();
        products.forEach(product -> {
            cache.putCache(product);
        });
    }
}
