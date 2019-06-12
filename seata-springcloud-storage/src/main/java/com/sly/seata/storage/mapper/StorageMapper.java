package com.sly.seata.storage.mapper;

import com.sly.seata.common.model.storage.Storage;

/**
 * 仓储mapper
 * 
 * @author sly
 * @time 2019年6月12日
 */
public interface StorageMapper {

	/**
	 * 新增
	 * 
	 * @param storage
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
	int insert(Storage storage);

}
