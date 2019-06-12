package com.sly.seata.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sly.seata.account.service.AccountService;
import com.sly.seata.business.service.BusinessService;
import com.sly.seata.order.service.OrderService;
import com.sly.seata.storage.service.StorageService;

/**
 * 业务service实现
 * 
 * @author sly
 * @time 2019年6月12日
 */
@Service
public class BusinessServiceImpl implements BusinessService {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private StorageService storageService;

}
