package com.xiang.manager.controller;

import com.xiang.entity.Product;
import com.xiang.manager.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController
{
    private static Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService service;

    @ApiOperation(value = "创建产品",notes = "根据业务规则添加相应的产品")
    @RequestMapping(value = "" ,method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product product)
    {
        LOG.info("创建产品，参数：{}",product);
        Product result = service.addProduct(product);
        LOG.info("创建产品，结果：{}",product);
        return result;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Product findOne(@PathVariable String id)
    {
        LOG.info("查询单个产品，id={}",id);
        Product product = service.findOne(id);
        LOG.info("查询单个产品，结果={}",product);
        return product;
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.GET)
    public Page<Product> query(String ids, BigDecimal minRewardRate, BigDecimal maxRewarRate, String status, int pageNum, int pageSize)
    {
        LOG.info("查询产品，ids={},minRewardRate={},minRewardRate={},status={},pageNum={},pageSize={}",ids,minRewardRate,maxRewarRate,status,pageNum,pageSize);
        List<String> idList = null , statusList = null;
        if(!StringUtils.isEmpty(ids))
        {
            idList = Arrays.asList(ids.split(","));
        }
        if(!StringUtils.isEmpty(status))
        {
            statusList = Arrays.asList(status.split(","));
        }
        Pageable pageable = new PageRequest(pageNum,pageSize);
        Page<Product> results = service.query(idList,minRewardRate,maxRewarRate,statusList,pageable);
        LOG.info("查询产品，结果={}",results);
        return results;
    }

}
