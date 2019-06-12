package com.sly.seata.business.service;

import org.springframework.cloud.openfeign.FeignClient;

import com.sly.seata.business.service.hystrix.BusinessServiceHystrixImpl;

/**
 * Business feign客户端
 * @author sly
 * @time 2019年6月12日
 */
@FeignClient(name = "seata-springcloud-business", fallback = BusinessServiceHystrixImpl.class)
public interface BusinessService {

}
