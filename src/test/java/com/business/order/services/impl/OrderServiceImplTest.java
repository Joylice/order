package com.business.order.services.impl;

import com.business.order.dataobject.OrderMaster;
import com.business.order.repository.OrderMasterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceImplTest {

    @Autowired
    OrderMasterRepository orderMasterRepository;

    @Test
    public void create() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerAddress("111");
        orderMaster.setPayStatus((byte) 0);
        orderMaster.setOrderStatus((byte) 0);
        orderMaster.setOrderId("111111");
        orderMaster.setBuyerOpenid("122334344");
        orderMasterRepository.save(orderMaster);
    }
}