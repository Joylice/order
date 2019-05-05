package com.business.order.exception;

public class OrderException extends RuntimeException {
    private Integer code;
    private String message;

   public  OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

}
