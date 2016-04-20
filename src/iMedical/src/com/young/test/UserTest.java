package com.young.test;

import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;
import com.young.iMedical.container.ServiceProvider;
import com.young.iMedical.domain.Memorandum;
import com.young.iMedical.domain.User;
import com.young.iMedical.service.DoctorService;
import com.young.iMedical.service.LogService;
import com.young.iMedical.service.MedicineService;
import com.young.iMedical.service.MemorandumService;
import com.young.iMedical.service.PreMedicineService;
import com.young.iMedical.service.PrescriptionService;
import com.young.iMedical.service.UserService;
import com.young.iMedical.web.vo.MedKitData;

public class UserTest {
	private UserService userService = (UserService) ServiceProvider
			.getService(UserService.SERVICE_NAME);
	private DoctorService doctorService = (DoctorService) ServiceProvider
			.getService(DoctorService.SERVICE_NAME);

	private LogService logService = (LogService) ServiceProvider
			.getService(LogService.SERVICE_NAME);
	private MedicineService medicineService = (MedicineService) ServiceProvider
			.getService(MedicineService.SERVICE_NAME);
	private PrescriptionService prescriptionService = (PrescriptionService) ServiceProvider
			.getService(PrescriptionService.SERVICE_NAME);
	private MemorandumService memorandumService = (MemorandumService) ServiceProvider
			.getService(MemorandumService.SERVICE_NAME);
	private PreMedicineService pms = (PreMedicineService) ServiceProvider
			.getService(PreMedicineService.SERVICE_NAME);

	// @Test
	// public void addUser() {
	// User user = new User();
	// user.setUsername("赵奕祺 ");
	// user.setPassword(MD5Utils.md5("123"));
	// user.setGender(1);
	// user.setBirthday(new java.sql.Date(StringUtils.stringConvertDate(
	// "1995-05-20").getTime()));
	// userService.saveUser(user);
	// }

	// @Test
	// public void addDoctor() {
	// Doctor doctor = new Doctor();
	// doctor.setName("李医生");
	// doctor.setPassword(MD5Utils.md5("123"));
	// doctor.setGender(1);
	// doctor.setBirthday(new java.sql.Date(StringUtils.stringConvertDate(
	// "1965-05-20").getTime()));
	// doctor.setHospital("广工大医院");
	// doctorService.saveDoctor(doctor);
	// }
	// @SuppressWarnings("unchecked")
	// @Test
	// public void findUser() {
	// User user = userService
	// .findUserById("4028472a5388c45e015388c461590001");
	// System.out.println(user.getUsername() + user.getPassword());
	// }
	// @Test
	// public void testLog() {
	// String[] ids = new String[] { "4028472a53972b6d0153972b74fc0001" };
	// // logService.deleteLogByLogId("4028472a53972b6d0153972b74fc0001");
	// logService.deleteLogByLogIDs(ids);
	// }
	// @Test
	// public void testMed() {
	// String id = "4028472a539715930153971f56a00001";
	// medicineService.deleteMedById(id);
	// }
	// @Test
	// public void testPres() {
	// String doc_id = "4028472a5389f3d1015389f3d5000001";
	// String user_id = "2c948a825389aae0015389aae3650001";
	// User user = userService.findUserById(user_id);
	// Doctor doctor = doctorService.findDoctorById(doc_id);
	// PreMedicine pm1 = new PreMedicine();
	// PreMedicine pm2 = new PreMedicine();
	// pm1.setName("999感冒灵");
	// pm1.setMethod("一次一袋，每日3次");
	// pm1.setQuantity(1);
	// pm1.setPerNum(10);
	// pm1.setTotalNum(pm1.getPerNum() * pm1.getQuantity());
	// pm1.setType("感冒药");
	// pm2.setName("VC银翘片");
	// pm2.setMethod("一次3粒，每日3次");
	// pm2.setQuantity(2);
	// pm2.setPerNum(50);
	// pm2.setTotalNum(pm2.getPerNum() * pm2.getQuantity());
	// pm2.setType("感冒药");
	// Set<PreMedicine> medicines = new HashSet<>();
	// medicines.add(pm1);
	// medicines.add(pm2);
	// Prescription prescription = new Prescription();
	// prescription.setDoctor(doctor);
	// prescription.setUser(user);
	// prescription.setPurpose("感冒");
	// prescription.setMedicines(medicines);
	// prescription.setTime(new java.sql.Date(StringUtils.stringConvertDate(
	// "2016-05-20").getTime()));
	// prescriptionService.savePres(prescription);
	// }
	// @Test
	// public void testDate() {
	// Date date = StringUtils.stringConvertDate("2016-03-24");
	// System.out.println(StringUtils.addDate(date, 40).toString());
	// }
	// @Test
	// public void testTime() {
	// String time = "12:12:12";
	// java.sql.Time sqlTime = StringUtils.stringToSqlTime(time);
	// System.out.println(sqlTime);
	// System.out.println(StringUtils.sqlTimeToString(sqlTime));
	// }
	// @Test
	// public void testString() {
	// String[] str = { "1", "2", "3", "4" };
	// for (int i = 0; i < str.length; i++) {
	// System.out.println(str[i] + "\t");
	// }
	// Integer[] intArr = StringUtils.stringArrayToIntegerArray(str);
	// for (int i = 0; i < intArr.length; i++) {
	// System.out.println(intArr[i] + "\t");
	// }
	// }
	// @Test
	// public void android_memo_list() {
	// User user = userService.findUserByName("陈仁煌");
	// List<Memorandum> memoList = memorandumService.findMemoByUser(user);
	// List<MemorandumForm> voList = memorandumService.POconvertVO(memoList);
	// Gson gson = new Gson();
	// String str = gson.toJson(voList);
	// System.out.println(str);
	// }
	// @Test
	// public void android_userPres_list() {
	// User user = userService.findUserByName("陈仁煌");
	// List<Prescription> presList = prescriptionService.findPresByUser(user);
	// List<PrescriptionForm> voList = POconvertVO(presList);
	// Gson gson = new Gson();
	// String str = gson.toJson(voList);
	// System.out.println(str);
	// }
	//
	// private List<PrescriptionForm> POconvertVO(List<Prescription> list) {
	// List<PrescriptionForm> voList = new ArrayList<PrescriptionForm>();
	// PrescriptionForm pf = null;
	// for (int i = 0; list != null && i < list.size(); i++) {
	// Prescription prescription = list.get(i);
	// pf = new PrescriptionForm();
	// pf.setUsername(prescription.getUser().getUsername());
	// pf.setPre_id(prescription.getPre_id());
	// pf.setPurpose(prescription.getPurpose());
	// pf.setDoctorName(prescription.getDoctor().getName());
	// pf.setTime(prescription.getTime());
	// pf.setMedicines(pms.POconvertVO(prescription.getMedicines()));
	// voList.add(pf);
	// }
	// return voList;
	// }
	@Test
	public void medkit() {
		User user = userService.findUserByName("陈仁煌");
		List<Memorandum> memoList = memorandumService.findMemoByUser(user);
		List<MedKitData> voList = memorandumService.PO2MedKit(memoList);
		Gson gson = new Gson();
		String str = gson.toJson(voList);
		System.out.println(str);
	}
}
