package com.business.order.exception;

import com.business.order.enums.ResultEnum;

public class OrderException extends RuntimeException {
    private Integer code;
    private String message;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
