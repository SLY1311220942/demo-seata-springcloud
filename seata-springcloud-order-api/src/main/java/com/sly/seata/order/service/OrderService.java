package com.sly.seata.order.service;

import org.springframework.cloud.openfeign.FeignClient;

import com.sly.seata.order.service.hystrix.OrderServiceHystrixImpl;

/**
 * Order feign客户端
 * 
 * @author sly
 * @time 2019年6月12日
 */
@FeignClient(name = "seata-springcloud-order", fallback = OrderServiceHystrixImpl.class)
public interface OrderService {

}
