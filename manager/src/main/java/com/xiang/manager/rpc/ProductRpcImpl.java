package com.xiang.manager.rpc;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import com.xiang.api.ProductRpc;
import com.xiang.api.domain.ProductRpcReq;
import com.xiang.entity.Product;
import com.xiang.manager.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产品相关rpc服务实现类
 * @author guixiang
 * @date 2018-09-09
 */
@AutoJsonRpcServiceImpl
@Service
public class ProductRpcImpl implements ProductRpc
{
    private static final Logger LOG = LoggerFactory.getLogger(ProductRpcImpl.class);

    @Autowired
    private ProductService service;

    @Override
    public List<Product> query(ProductRpcReq req)
    {
        LOG.info("查询多个产品，参数：{}",req);
        Pageable pageable = new PageRequest(0,100,Sort.Direction.DESC,"rewardRate");
//        Page<Product> result = service.query(req.getIdList(),req.getMinRewardRate()
//                ,req.getMaxRewarRate(),req.getStatusList(),req.getPageable());
        Page<Product> result = service.query(req.getIdList(),req.getMinRewardRate()
                ,req.getMaxRewarRate(),req.getStatusList(),pageable);
        LOG.info("查询多个产品，结果：{}",result);
        return result.getContent();
    }

    @Override
    public Product findOne(String id)
    {
        LOG.info("查询单个产品，参数：{}",id);
        Product result = service.findOne(id);
        LOG.info("查询单个产品，结果：{}",result);
        return result;
    }
}
