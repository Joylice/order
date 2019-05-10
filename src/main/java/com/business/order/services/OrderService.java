package com.business.order.services;

import com.business.order.DTO.OrderDTO;

public interface OrderService {
    OrderDTO create(OrderDTO orderDTO);
}
