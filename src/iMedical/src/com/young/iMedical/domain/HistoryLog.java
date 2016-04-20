package com.young.iMedical.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@SuppressWarnings("serial")
public class HistoryLog implements Serializable {
	private int log_id;
	private String username;
	private String content;
	private Date date;
	private Time setTime;
	private Time actualTime;
	private int state; // 已经吃药设为1，否则设为0

	public int getLog_id() {
		return log_id;
	}

	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getSetTime() {
		return setTime;
	}

	public void setSetTime(Time setTime) {
		this.setTime = setTime;
	}

	public Time getActualTime() {
		return actualTime;
	}

	public void setActualTime(Time actualTime) {
		this.actualTime = actualTime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}
