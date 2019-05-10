package com.business.order.controller;

import com.business.order.DTO.CartDTO;
import com.business.order.client.ProductClient;
import com.business.order.dataobject.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class clientController {
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        // String response = restTemplate.getForObject("http://product/msg", String.class);
        String response = productClient.msg();
        log.info("response={}", response);
        return response;
    }

    @GetMapping("/product/list")
    public List<ProductInfo> getProductInfoList() {
        List<ProductInfo> productInfos = productClient.getProductInfoList(Arrays.asList("164103465734242707", "157875196366160022"));
        log.info("productInfos={}", productInfos);
        return productInfos;
    }

    @GetMapping("/decreaseStock")
    public String decreaseStocke() {
        productClient.decreaseStock(Arrays.asList(new CartDTO("164103465734242707", 3)));
        return "ok";
    }
}
