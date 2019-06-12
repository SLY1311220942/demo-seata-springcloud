package com.sly.seata.common.model.account;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 账户实体类
 * 
 * @author sly
 * @time 2019年6月10日
 */
public class Account implements Serializable {

	private static final long serialVersionUID = 3151815049700190828L;

	/** varchar(32) NOT NULL主键uuid */
	private String accountId;
	/** decimal(18,6) NULL金额 */
	private BigDecimal amount;
	/** varchar(32) NULL账户名称 */
	private String accountName;
	/** char(1) NULL逻辑删除 Y:删除 N:未删除 */
	private String logicDel;
	/** varchar(240) NULL备注 */
	private String remark;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
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
