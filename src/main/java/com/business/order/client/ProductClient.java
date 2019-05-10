package com.business.order.client;

import com.business.order.DTO.CartDTO;
import com.business.order.dataobject.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("product")
public interface ProductClient {

    @GetMapping("/msg")
    String msg();

    @PostMapping("/product/listForOrder")
    List<ProductInfo> getProductInfoList(@RequestBody List<String> productIds);

    @PostMapping("/decreaseStock")
    void decreaseStock(@RequestBody List<CartDTO> cartDTOS);
}
