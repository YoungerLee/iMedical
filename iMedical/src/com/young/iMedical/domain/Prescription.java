package com.young.iMedical.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@SuppressWarnings("serial")
public class Prescription implements Serializable {
	private String pre_id;
	private String purpose;
	private Date time;
	private Set<PreMedicine> medicines;
	private User user;
	private Doctor doctor;

	public String getPre_id() {
		return pre_id;
	}

	public void setPre_id(String pre_id) {
		this.pre_id = pre_id;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Set<PreMedicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(Set<PreMedicine> medicines) {
		this.medicines = medicines;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
}
