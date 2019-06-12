package com.sly.seata.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sly.seata.account.mapper.AccountMapper;
import com.sly.seata.account.service.AccountService;

/**
 * 账户service实现
 * 
 * @author sly
 * @time 2019年6月12日
 */
@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountMapper accountMapper;

}
