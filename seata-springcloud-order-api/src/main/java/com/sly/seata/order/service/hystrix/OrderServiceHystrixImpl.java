package com.sly.seata.order.service.hystrix;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sly.seata.common.model.order.Order;
import com.sly.seata.order.service.OrderService;

/**
 * Order熔断
 * 
 * @author sly
 * @time 2019年6月12日
 */
@Component
public class OrderServiceHystrixImpl implements OrderService {

	/**
	 * 新增失败熔断返回
	 * 
	 * @param order
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
	@Override
	public Map<String, Object> insert(Order order) {
		Map<String, Object> result = new HashMap<>(16);
		result.put("status", 400);
		result.put("message", "调用订单新增服务失败！");
		return result;
	}

}
