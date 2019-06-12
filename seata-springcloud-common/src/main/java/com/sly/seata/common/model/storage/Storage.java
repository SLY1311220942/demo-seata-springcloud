package com.sly.seata.common.model.storage;

import java.io.Serializable;

/**
 * 仓储实体类
 * 
 * @author sly
 * @time 2019年6月10日
 */
public class Storage implements Serializable {

	private static final long serialVersionUID = 2354844711437514051L;

	/** varchar(32) NOT NULL主键uuid */
	private String storageId;
	/** varchar(32) NULL仓储名称 */
	private String storageName;
	/** int(11) NULL数量 */
	private Integer storageCount;
	/** char(1) NULL逻辑删除 Y:删除 N:未删除 */
	private String logicDel;
	/** varchar(240) NULL备注 */
	private String remark;

	public String getStorageId() {
		return storageId;
	}

	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}

	public String getStorageName() {
		return storageName;
	}

	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}

	public Integer getStorageCount() {
		return storageCount;
	}

	public void setStorageCount(Integer storageCount) {
		this.storageCount = storageCount;
	}

	public String getLogicDel() {
		return logicDel;
	}

	public void setLogicDel(String logicDel) {
		this.logicDel = logicDel;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
