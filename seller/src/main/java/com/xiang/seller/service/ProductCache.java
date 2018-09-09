package com.xiang.seller.service;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.xiang.api.ProductRpc;
import com.xiang.api.domain.ProductRpcReq;
import com.xiang.entity.Product;
import com.xiang.entity.enums.ProductStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastInstanceFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 注意：@Cacheable、@CacheEvict等缓存功能在当前类不生效
 * 产品缓存
 * @author guixiang
 * @Date 2018-09-09
 */
@Component
public class ProductCache
{
    private static Logger LOG = LoggerFactory.getLogger(ProductCache.class);

    static final String CACHE_NAME = "xx_products";

    @Autowired
    private ProductRpc productRpc;

    @Autowired
    private HazelcastInstance hazelcastInstance;

    @Cacheable(cacheNames = CACHE_NAME)
    public Product readCache(String id)
    {
        LOG.info("查询单个产品，参数：{}",id);
        Product result = productRpc.findOne(id);
        LOG.info("查询单个产品，结果：{}",result);
       return result;
    }

    @CachePut(cacheNames = CACHE_NAME,key = "#product.id")
    public Product putCache(Product product)
    {
        return product;
    }

    @CacheEvict(cacheNames = CACHE_NAME)
    public void removeCache(String id)
    {

    }

    public List<Product> readAllCache()
    {
        Map map = hazelcastInstance.getMap(CACHE_NAME);
        List<Product> products= null;
        if(map.size() > 0)
        {
            products = new ArrayList<Product>();
            products.addAll(map.values());
        }
        else
        {
            products = findAll();
        }
        return products;
    }

    public List<Product> findAll()
    {
        ProductRpcReq req = new ProductRpcReq();
        List<String> status = new ArrayList<String >();
        status.add(ProductStatus.IN_SELL.name());
        Pageable pageable = new PageRequest(0,100,Sort.Direction.DESC,"rewardRate");
        req.setStatusList(status);
//        req.setPageable(pageable);
//        req.setPage(0);
//        req.setSize(100);
//        req.setDirection(Sort.Direction.DESC);
//        req.setOrderBy("rewardRate");
        LOG.info("查询全部产品，参数：{}",req);
        List<Product> result = productRpc.query(req);
        LOG.info("rpc查询全部产品，结果：{}",result);
        return result;
    }
}
