package com.business.order.services.impl;

import com.business.order.dataobject.OrderMaster;
import com.business.order.dto.OrderDTO;
import com.business.order.enums.OrderStatusEnum;
import com.business.order.enums.PayStatusEnum;
import com.business.order.repository.OrderDetailRepository;
import com.business.order.repository.OrderMasterRepository;
import com.business.order.services.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMasterRepository orderMasterRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId("1223234343");
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode().byteValue());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode().byteValue());
        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }


}
