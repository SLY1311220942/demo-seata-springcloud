package com.sly.seata.storage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sly.seata.storage.mapper.StorageMapper;
import com.sly.seata.storage.service.StorageService;

/**
 * 仓储service实现
 * 
 * @author sly
 * @time 2019年6月12日
 */
@Service
public class StorageServiceImpl implements StorageService {
	
	@Autowired
	private StorageMapper storageMapper;
}
