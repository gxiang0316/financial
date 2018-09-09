package com.xiang.api.domain;

import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.List;

/**
 * 产品rpc请求参数对象
 * @author guixiang
 * @date 2018-09-09
 */
public class ProductRpcReq
{
    private List<String> idList;
    private BigDecimal minRewardRate;
    private BigDecimal maxRewarRate;
    private List<String> statusList;
    /*rpc参数不支持复杂对象，因此改造pageable
    private Pageable pageable*/;
    private int page;
    private int size;
    private Sort.Direction direction;
    private String orderBy;

    public List<String> getIdList() {
        return idList;
    }

    public void setIdList(List<String> idList) {
        this.idList = idList;
    }

    public BigDecimal getMinRewardRate() {
        return minRewardRate;
    }

    public void setMinRewardRate(BigDecimal minRewardRate) {
        this.minRewardRate = minRewardRate;
    }

    public BigDecimal getMaxRewarRate() {
        return maxRewarRate;
    }

    public void setMaxRewarRate(BigDecimal maxRewarRate) {
        this.maxRewarRate = maxRewarRate;
    }

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Sort.Direction getDirection() {
        return direction;
    }

    public void setDirection(Sort.Direction direction) {
        this.direction = direction;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    @Override
    public String toString() {
        return "ProductRpcReq{" +
                "idList=" + idList +
                ", minRewardRate=" + minRewardRate +
                ", maxRewarRate=" + maxRewarRate +
                ", statusList=" + statusList +
                ", page=" + page +
                ", size=" + size +
                ", direction=" + direction +
                ", orderBy='" + orderBy + '\'' +
                '}';
    }
}
