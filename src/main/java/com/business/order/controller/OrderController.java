package com.business.order.controller;

import com.business.order.enums.ResultEnum;
import com.business.order.exception.OrderException;
import com.business.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    /***
     * 1.参数校验
     * 2.查询商品信息（调用商品服务）
     * 3.计算总价
     * 4.扣库存（调用商品服务）
     * 5.订单入库
     * @return
     */
    @PostMapping("/create")
    public String create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确，orderForm={}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        return "";
    }
}