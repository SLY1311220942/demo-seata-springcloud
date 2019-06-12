package com.sly.seata.order.mapper;

import com.sly.seata.common.model.order.Order;

/**
 * 订单mapper
 * 
 * @author sly
 * @time 2019年6月12日
 */
public interface OrderMapper {

	/**
	 * 新增
	 * 
	 * @param order
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
	int insert(Order order);

}
