package com.business.order.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class ProductInfo {
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private int productStock;
    private String productDescription;
    private String productIcon;
    private Integer productStatus;
    private int categoryType;
    private Timestamp createTime;
    private Timestamp updateTime;
}
