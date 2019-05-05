package com.business.order.services.impl;

import com.business.order.dataobject.OrderDetail;
import com.business.order.dataobject.OrderMaster;
import com.business.order.dto.OrderDTO;
import com.business.order.repository.OrderDetailRepository;
import com.business.order.repository.OrderMasterRepository;
import com.business.order.services.OrderService;
import org.hibernate.id.GUIDGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMasterRepository orderMasterRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(UUID.randomUUID().toString());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        return null;
    }
}
