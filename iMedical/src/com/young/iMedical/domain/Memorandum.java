package com.young.iMedical.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@SuppressWarnings("serial")
public class Memorandum implements Serializable {
	private int mem_id;
	private String content;
	private Date beginDate;
	private Date endDate;
	private Time time;
	private User user;
	private Prescription prescription;
	private PreMedicine preMedicine;

	public Memorandum() {
	}

	public int getMem_id() {
		return mem_id;
	}

	public void setMem_id(int mem_id) {
		this.mem_id = mem_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public PreMedicine getPreMedicine() {
		return preMedicine;
	}

	public void setPreMedicine(PreMedicine preMedicine) {
		this.preMedicine = preMedicine;
	}
}
