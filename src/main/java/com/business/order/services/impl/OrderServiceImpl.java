package com.business.order.services.impl;

import com.business.order.DTO.CartDTO;
import com.business.order.client.ProductClient;
import com.business.order.dataobject.OrderDetail;
import com.business.order.dataobject.OrderMaster;
import com.business.order.DTO.OrderDTO;
import com.business.order.dataobject.ProductInfo;
import com.business.order.enums.OrderStatusEnum;
import com.business.order.enums.PayStatusEnum;
import com.business.order.repository.OrderDetailRepository;
import com.business.order.repository.OrderMasterRepository;
import com.business.order.services.OrderService;
import com.business.order.utils.KeyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMasterRepository orderMasterRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Autowired
    ProductClient productClient;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtils.getUniqueKey();
        //查询商品信息
        List<String> productIdList = orderDTO.getOrderDetails().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfo> productInfoList = productClient.getProductInfoList(productIdList);
        //计算总价
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail : orderDTO.getOrderDetails()) {
            for (ProductInfo productInfo : productInfoList) {
                if (orderDetail.getProductId().equals(productInfo.getProductId())) {
                    orderAmount = new BigDecimal(orderDetail.getProductQuantity())
                            .multiply(productInfo.getProductPrice())
                            .add(orderAmount);
                    BeanUtils.copyProperties(orderDTO, orderDetail);
                    orderDetail.setOrderId();
                    orderDetail.setDetailId(KeyUtils.getUniqueKey());
                }
            }
        }
        //扣库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetails().stream()
                .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(cartDTOList);

        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode().byteValue());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode().byteValue());
        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }


}
