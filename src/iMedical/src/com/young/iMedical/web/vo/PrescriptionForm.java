package com.young.iMedical.web.vo;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class PrescriptionForm implements Serializable {
	private String pre_id;
	private String purpose;
	private String time;
	private List<PreMedicineForm> medicines;
	private String username;
	private String doctorName;

	public PrescriptionForm() {
	}

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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<PreMedicineForm> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<PreMedicineForm> medicines) {
		this.medicines = medicines;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
}
