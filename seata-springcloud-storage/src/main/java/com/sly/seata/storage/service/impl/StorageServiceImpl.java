package com.sly.seata.storage.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sly.seata.common.model.storage.Storage;
import com.sly.seata.storage.mapper.StorageMapper;
import com.sly.seata.storage.service.StorageService;

import io.seata.core.context.RootContext;

/**
 * 仓储service实现
 * 
 * @author sly
 * @time 2019年6月12日
 */
@RestController
public class StorageServiceImpl implements StorageService {

	@Autowired
	private StorageMapper storageMapper;

	/**
	 * 新增
	 * 
	 * @param storage
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
	@Override
	public Map<String, Object> insert(@RequestBody Storage storage) {
		System.out.println(RootContext.getXID());
		//int a = 10/0;
		storageMapper.insert(storage);
		
		
		Map<String, Object> result = new HashMap<>(16);
		result.put("status", 200);
		result.put("message", "新增成功！");
		return result;
	}
}
