package com.sly.seata.common.model.order;

import java.io.Serializable;

/**
 * 订单实体类
 * 
 * @author sly
 * @time 2019年6月10日
 */
public class Order implements Serializable {

	private static final long serialVersionUID = 8600549941188317014L;

	/** varchar(32) NOT NULL主键uuid */
	private String orderId;
	/** varchar(32) NULL订单号 */
	private String orderNo;
	/** varchar(240) NULL订单详情 */
	private String orderDetail;
	/** varchar(24) NULL创建时间 */
	private String createTime;
	/** char(1) NULL逻辑删除 Y:删除 N:未删除 */
	private String logicDel;
	/** varchar(240) NULL备注 */
	private String remark;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(String orderDetail) {
		this.orderDetail = orderDetail;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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
