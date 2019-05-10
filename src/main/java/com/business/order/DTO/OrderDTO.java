package com.business.order.DTO;

import com.business.order.dataobject.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDTO {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    private byte orderStatus;
    private byte payStatus;
    private List<OrderDetail> orderDetails;
}
