package com.xiang.seller.controller;

import com.xiang.entity.Product;
import com.xiang.seller.service.ProductRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guixiang
 * @date 2018-09-09
 */
@RestController
public class ProductController
{
    @Autowired
    private ProductRpcService service;

    @RequestMapping("/{id}")
    public Product findOne(@PathVariable String id)
    {
        return service.findOne(id);
    }
}
