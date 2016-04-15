package com.young.iMedical.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MedGrade implements Serializable {
	private Integer user_id;
	private Integer med_id;
	private double grade;

	public MedGrade() {

	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getMed_id() {
		return med_id;
	}

	public void setMed_id(Integer med_id) {
		this.med_id = med_id;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}
}
