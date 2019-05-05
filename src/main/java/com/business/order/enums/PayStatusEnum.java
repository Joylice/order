package com.business.order.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功");
    private Integer code;
    private String name;

    PayStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
