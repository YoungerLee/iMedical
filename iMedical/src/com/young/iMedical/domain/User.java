package com.young.iMedical.domain;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class User implements Serializable {
	private String id;
	private String username;
	private String password;
	private int gender; // 1为男，0为女
	private Date birthday;

	public User() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}