package com.xiang.manager.service;

import com.xiang.api.events.ProductStatusEvent;
import com.xiang.entity.enums.ProductStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * 管理产品状态改变
 */
@Component
public class ProductStatusManager
{
    static final String MQ_DESTINATION = "VirtualTopic.PRODUCT_STATUS";

    @Autowired
    private JmsTemplate jmsTemplate;

    public void changeStatus(String id, ProductStatus productStatus)
    {
        ProductStatusEvent event = new ProductStatusEvent(id,productStatus);
        jmsTemplate.convertAndSend(MQ_DESTINATION,event);
    }
}
