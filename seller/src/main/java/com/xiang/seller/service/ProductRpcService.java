package com.xiang.seller.service;

import com.xiang.api.ProductRpc;
import com.xiang.api.domain.ProductRpcReq;
import com.xiang.entity.Product;
import com.xiang.entity.enums.ProductStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * 产品服务
 * @author guixiang
 * @date 2018-09-09
 */
@Service
public class ProductRpcService
{
    private static Logger LOG = LoggerFactory.getLogger(ProductRpcService.class);

    @Autowired
    private ProductRpc productRpc;

    /**
     * 查询全部产品
     * @return
     */
    @Bean
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

    /**
     * 测试
     */
    @PostConstruct
    public void testFindAll()
    {
        findAll();
    }
}
