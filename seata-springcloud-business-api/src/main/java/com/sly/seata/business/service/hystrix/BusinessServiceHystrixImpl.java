package com.sly.seata.business.service.hystrix;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sly.seata.business.service.BusinessService;

/**
 * Business熔断
 * 
 * @author sly
 * @time 2019年6月12日
 */
@Component
public class BusinessServiceHystrixImpl implements BusinessService {

	/**
	 * 付款失败熔断返回
	 * 
	 * @param accountId
	 * @param orderId
	 * @param storageId
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
	@Override
	public Map<String, Object> purchase(String accountId, String orderId, String storageId) {
		Map<String, Object> result = new HashMap<>(16);
		result.put("status", 400);
		result.put("message", "调用付款服务失败！");
		return result;
	}

}
