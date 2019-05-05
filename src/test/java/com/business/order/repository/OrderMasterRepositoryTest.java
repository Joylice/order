package com.business.order.repository;

import com.business.order.OrderApplicationTests;
import com.business.order.dataobject.OrderMaster;
import com.business.order.enums.OrderStatusEnum;
import com.business.order.enums.PayStatusEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired
    OrderMasterRepository orderMasterRepository;

    @Test
    public void orderMasterSave() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerName("tester");
        orderMaster.setBuyerOpenid("111111111");
        orderMaster.setBuyerPhone("111222");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderId("123232");
        orderMaster.setBuyerAddress("北京");
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode().byteValue());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode().byteValue());

        orderMasterRepository.save(orderMaster);
    }
}