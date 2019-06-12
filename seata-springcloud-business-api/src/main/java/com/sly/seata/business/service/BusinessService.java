package com.sly.seata.business.service;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sly.seata.business.service.hystrix.BusinessServiceHystrixImpl;

/**
 * Business feign客户端
 * 
 * @author sly
 * @time 2019年6月12日
 */
@FeignClient(name = "seata-springcloud-business", fallback = BusinessServiceHystrixImpl.class)
public interface BusinessService {

	/**
	 * 购买
	 * 
	 * @param accountId
	 * @param orderId
	 * @param storageId
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
	@RequestMapping(value = "/business/purchase", method = RequestMethod.POST)
	Map<String, Object> purchase(@RequestParam("accountId") String accountId, @RequestParam("orderId") String orderId,
			@RequestParam("storageId") String storageId);

}
