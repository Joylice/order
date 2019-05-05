package com.business.order.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    NEW(1, "新订单"),

    FINISHED(2, "完结"),

    CANCEL(3, "取消");

    private Integer code;
    private String name;

    OrderStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
