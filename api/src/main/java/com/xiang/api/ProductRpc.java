package com.xiang.api;

import com.googlecode.jsonrpc4j.JsonRpcService;
import com.xiang.api.domain.ProductRpcReq;
import com.xiang.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 产品相关的rpc服务
 * @author guixiang
 * @date 2018-09-09
 */
@JsonRpcService("rpc/products")
public interface ProductRpc
{
    /**
     * 查询多个产品
     * @param req
     * @return
     */
     List<Product> query(ProductRpcReq req);

    /**
     * 查询单个产品
     * @param id
     * @return
     */
    Product findOne(String id);
}
