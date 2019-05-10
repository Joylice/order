package com.business.order.utils;

import com.business.order.dataobject.OrderDetail;
import com.business.order.DTO.OrderDTO;
import com.business.order.enums.ResultEnum;
import com.business.order.exception.OrderException;
import com.business.order.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OrderForm2OrderDTO {

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        List<OrderDetail> orderDetails = new ArrayList<>();
        try {
            orderDetails = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        } catch (Exception e) {
            log.error("【json转换】错误，string={}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetails(orderDetails);
        return orderDTO;
    }
}
