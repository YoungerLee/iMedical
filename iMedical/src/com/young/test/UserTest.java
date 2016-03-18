package com.young.test;

import org.junit.Test;

import com.young.iMedical.container.ServiceProvider;
import com.young.iMedical.domain.Doctor;
import com.young.iMedical.service.DoctorService;
import com.young.iMedical.service.UserService;
import com.young.iMedical.util.MD5Utils;
import com.young.iMedical.util.StringUtils;

public class UserTest {
	private UserService userService = (UserService) ServiceProvider
			.getService(UserService.SERVICE_NAME);
	private DoctorService doctorService = (DoctorService) ServiceProvider
			.getService(DoctorService.SERVICE_NAME);

	// @Test
	// public void addUser() {
	// User user = new User();
	// user.setUsername("young");
	// user.setPassword(MD5Utils.md5("young"));
	// user.setGender(1);
	// user.setBirthday(new java.sql.Date(StringUtils.stringConvertDate(
	// "1995-05-20").getTime()));
	// userService.saveUser(user);
	// }
	@Test
	public void addDoctor() {
		Doctor doctor = new Doctor();
		doctor.setName("李医生");
		doctor.setPassword(MD5Utils.md5("123"));
		doctor.setGender(1);
		doctor.setBirthday(new java.sql.Date(StringUtils.stringConvertDate(
				"1965-05-20").getTime()));
		doctor.setHospital("广工大医院");
		doctorService.saveDoctor(doctor);
	}
	// @SuppressWarnings("unchecked")
	// @Test
	// public void findUser() {
	// User user = userService
	// .findUserById("4028472a5388c45e015388c461590001");
	// System.out.println(user.getUsername() + user.getPassword());
	// }
}
