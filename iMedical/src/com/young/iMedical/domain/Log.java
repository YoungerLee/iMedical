package com.young.iMedical.domain;

import java.io.Serializable;
import java.sql.Timestamp;

@SuppressWarnings("serial")
public class Log implements Serializable {
	private String id;
	private String operName;
	private Timestamp operTime;
	private String details;
	private String ipAddress;

	public Log() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

	public Timestamp getOperTime() {
		return operTime;
	}

	public void setOperTime(Timestamp operTime) {
		this.operTime = operTime;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
}
