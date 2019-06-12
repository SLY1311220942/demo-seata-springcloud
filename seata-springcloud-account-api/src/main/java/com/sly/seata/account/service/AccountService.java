package com.sly.seata.account.service;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sly.seata.account.service.hystrix.AccountServiceHystrixImpl;
import com.sly.seata.common.model.account.Account;

/**
 * Account feign客户端
 * 
 * @author sly
 * @time 2019年6月12日
 */
@FeignClient(name = "seata-springcloud-account", fallback = AccountServiceHystrixImpl.class)
public interface AccountService {
	
	/**
	 * 新增
	 * 
	 * @param account
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
	@RequestMapping(value = "/account/insert", method = RequestMethod.POST)
	Map<String, Object> insert(@RequestBody Account account);

}
