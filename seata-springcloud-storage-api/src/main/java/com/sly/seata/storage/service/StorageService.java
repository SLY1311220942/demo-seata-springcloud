package com.sly.seata.storage.service;

import org.springframework.cloud.openfeign.FeignClient;

import com.sly.seata.storage.service.hystrix.StorageServiceHystrixImpl;

/**
 * Storage feign客户端
 * 
 * @author sly
 * @time 2019年6月12日
 */
@FeignClient(name = "seata-springcloud-storage", fallback = StorageServiceHystrixImpl.class)
public interface StorageService {

}
