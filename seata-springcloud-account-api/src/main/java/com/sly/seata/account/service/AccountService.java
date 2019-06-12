package com.sly.seata.account.service;

import org.springframework.cloud.openfeign.FeignClient;

import com.sly.seata.account.service.hystrix.AccountServiceHystrixImpl;

/**
 * Account feign客户端
 * 
 * @author sly
 * @time 2019年6月12日
 */
@FeignClient(name = "seata-springcloud-account", fallback = AccountServiceHystrixImpl.class)
public interface AccountService {

}
