package com.young.iMedical.web.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MedKitData implements Serializable {
	private Integer med_id; // 药品id
	private String beginDate; // 开始日期
	private String endDate; // 结束日期
	private String time; // 提醒时间

	public Integer getMed_id() {
		return med_id;
	}

	public void setMed_id(Integer med_id) {
		this.med_id = med_id;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
