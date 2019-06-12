package com.sly.seata.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sly.seata.order.mapper.OrderMapper;
import com.sly.seata.order.service.OrderService;

/**
 * 订单service实现
 * 
 * @author sly
 * @time 2019年6月12日
 */
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderMapper orderMapper;

}
