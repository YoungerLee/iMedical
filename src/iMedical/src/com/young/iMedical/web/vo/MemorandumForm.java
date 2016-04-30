package com.young.iMedical.web.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MemorandumForm implements Serializable {
	private Integer mem_id; // 备忘录id
	private String username; // 用户名
	private String purpose; // 用途
	private String item; // 药名
	private String method; // 用法用量
	private String type; // 药品类型
	private Integer totalNum; // 剩余数量
	private String beginDate; // 开始日期
	private String endDate; // 结束日期
	private String morningTime; // 早上提醒时间(00:00:00~11:00:00)
	private String noonTime; // 中午提醒时间(11:00:00~17:00:00)
	private String eveningTime; // 晚上提醒时间(17:00:00~23:59:59)

	public MemorandumForm() {
	}

	public Integer getMem_id() {
		return mem_id;
	}

	public void setMem_id(Integer mem_id) {
		this.mem_id = mem_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getMorningTime() {
		return morningTime;
	}

	public void setMorningTime(String morningTime) {
		this.morningTime = morningTime;
	}

	public String getNoonTime() {
		return noonTime;
	}

	public void setNoonTime(String noonTime) {
		this.noonTime = noonTime;
	}

	public String getEveningTime() {
		return eveningTime;
	}

	public void setEveningTime(String eveningTime) {
		this.eveningTime = eveningTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mem_id == null) ? 0 : mem_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemorandumForm other = (MemorandumForm) obj;
		if (mem_id == null) {
			if (other.mem_id != null)
				return false;
		} else if (!mem_id.equals(other.mem_id))
			return false;
		return true;
	}
}
