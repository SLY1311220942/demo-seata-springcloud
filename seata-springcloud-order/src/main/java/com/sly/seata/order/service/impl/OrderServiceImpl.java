package com.sly.seata.order.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sly.seata.common.model.order.Order;
import com.sly.seata.order.mapper.OrderMapper;
import com.sly.seata.order.service.OrderService;

import io.seata.core.context.RootContext;

/**
 * 订单service实现
 * 
 * @author sly
 * @time 2019年6月12日
 */
@RestController
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;

	/**
	 * 新增
	 * 
	 * @param order
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
	@Override
	public Map<String, Object> insert(@RequestBody Order order) {
		System.out.println(RootContext.getXID());
		
		orderMapper.insert(order);
		Map<String, Object> result = new HashMap<>(16);
		result.put("status", 200);
		result.put("message", "新增成功！");
		return result;
	}

}
