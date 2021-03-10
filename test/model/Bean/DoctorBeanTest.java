/**
 * 
 */
package model.Bean;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Tamburello Martina
 *
 */
class DoctorBeanTest {

	DoctorBean doctor;
	DoctorBean doctor2;
	ArrayList<VisitTimetableBean> visitTimetables;
	VisitTimetableBean visitTimetable;
	ArrayList<MedicalRecordBean> medicalRecords;
	MedicalRecordBean medicalRecord;
	
	/**
	 * @throws java.lang.Exception
	 */
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		doctor = new DoctorBean();
		doctor2 = new DoctorBean("VRDLGI88O09P789F", "Luigi", "Verdi", "luigi@checkUp.it", "oculistica");
		medicalRecords = new ArrayList<MedicalRecordBean>();
		medicalRecord = new MedicalRecordBean();
		visitTimetables = new ArrayList<VisitTimetableBean>();
		visitTimetable = new VisitTimetableBean(doctor2.getFiscal_code()+"/"+new Date(2021-1900, 2-1, 7)+"/"+ new Time(15,00,00).toString().substring(0,5), doctor2, new Time(15,00,00), new Date(2021-1900, 2-1, 7), 30, true);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		doctor = null;
	}

	/**
	 * Test method for {@link model.Bean.DoctorBean#DoctorBean()}.
	 */
	@Test
	void testDoctorBeanEmptyConstructor() {
		doctor = new DoctorBean();
		assertNotNull(doctor);
	}

	/**
	 * Test method for {@link model.Bean.DoctorBean#DoctorBean(java.lang.String, java.lang.String, java.lang.String, java.sql.Date, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	void testDoctorBeanConstructor() {
		doctor = new DoctorBean("VRDLGI88O09P789F", "Luigi", "Verdi", new Date(1990-1900, 1-1, 20), "Napoli", "Napoli", "martina", 435464744, "luigi@checkUp.it", "oculistica");
		assertEquals("VRDLGI88O09P789F", doctor.getFiscal_code());
		assertEquals("Luigi", doctor.getUser_name());
		assertEquals("Verdi", doctor.getSurname());
		assertEquals(new Date(1990-1900, 1-1, 20), doctor.getBirth_date());
		assertEquals("Napoli", doctor.getBirth_place());
		assertEquals("Napoli", doctor.getResidence());
		assertEquals("martina", doctor.getUser_password());
		assertEquals(435464744, doctor.getPhone_number());
		assertEquals("luigi@checkUp.it", doctor.getEmail());
		assertEquals("oculistica", doctor.getSpecialization());
	}

	/**
	 * Test method for {@link model.Bean.DoctorBean#DoctorBean(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testDoctorBeanConstructor2() {
		doctor = new DoctorBean("VRDLGI88O09P789F", "Luigi", "Verdi", "luigi@checkUp.it", "oculistica");
		assertEquals("VRDLGI88O09P789F", doctor.getFiscal_code());
		assertEquals("Luigi", doctor.getUser_name());
		assertEquals("Verdi", doctor.getSurname());
		assertEquals("luigi@checkUp.it", doctor.getEmail());
		assertEquals("oculistica", doctor.getSpecialization());
	}

	/**
	 * Test method for {@link model.Bean.DoctorBean#getSpecialization()}.
	 */
	@Test
	void testGetSpecialization() {
		String specialization = doctor2.getSpecialization();
		assertEquals("oculistica", specialization);
	}

	/**
	 * Test method for {@link model.Bean.DoctorBean#setSpecialization(java.lang.String)}.
	 */
	@Test
	void testSetSpecialization() {
		doctor2.setSpecialization("allergologia");
		assertEquals("allergologia", doctor2.getSpecialization());
	}

	/**
	 * Test method for {@link model.Bean.DoctorBean#getVisitTimetable()}.
	 */
	@Test
	void testGetVisitTimetable() {
		visitTimetables = doctor2.getVisitTimetable();
		assertNotNull(visitTimetables);
	}

	/**
	 * Test method for {@link model.Bean.DoctorBean#addVisitTimetable(model.Bean.VisitTimetableBean)}.
	 */
	@Test
	void testAddVisitTimetable() {
		assertFalse(doctor.getVisitTimetable().contains(visitTimetable));
		doctor.addVisitTimetable(visitTimetable);
		assertTrue(doctor.getVisitTimetable().contains(visitTimetable));
	}

	/**
	 * Test method for {@link model.Bean.DoctorBean#getMedicalRecords()}.
	 */
	@Test
	void testGetMedicalRecords() {
		medicalRecords = doctor2.getMedicalRecords();
		assertNotNull(medicalRecords);
	}
	/**
	 * Test method for {@link model.Bean.DoctorBean#addMedicalRecord(model.Bean.MedicalRecordBean)}.
	 */
	@Test
	void testAddMedicalRecord() {
		assertFalse(doctor.getMedicalRecords().contains(medicalRecord));
		doctor.addMedicalRecord(medicalRecord);
		assertTrue(doctor.getMedicalRecords().contains(medicalRecord));
	}

}
