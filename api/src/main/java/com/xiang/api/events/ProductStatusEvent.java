package com.xiang.api.events;

import com.xiang.entity.enums.ProductStatus;

import java.io.Serializable;

/**
 * 产品事件状态
 * @author guixiang
 * @Date 2018-09-09
 */
public class ProductStatusEvent implements Serializable
{
    private String id;
    private ProductStatus productStatus;

    public ProductStatusEvent(String id,ProductStatus productStatus) {
        this.id = id;
        this.productStatus = productStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }
}
