package model.Bean;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.sql.Date;

import java.util.ArrayList;

class PatientBeanTest {

	PatientBean patient;
	PatientBean patient2;
	DoctorBean doc;
	ArrayList<BookingVisitBean> bookings;
	BookingVisitBean booking;
	ArrayList<MedicalRecordBean> medicalRecords;
	MedicalRecordBean medicalRecord;
	
	/**
	 * @throws java.lang.Exception
	 */
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		patient2 = new PatientBean();
		bookings = new ArrayList<BookingVisitBean>();
		patient = new PatientBean("RSSMRO88N75U789K", "Mario", "Rossi", new Date(1998-1900,11-1,24), "Napoli", "Napoli","martina", 435464744, "marioRossi@live.it");
		doc = new DoctorBean("VRDLGI88O09P789F", "Luigi", "Verdi", "luigi@checkUp.it", "oculistica");
		booking = new BookingVisitBean(patient, doc, new Date(2021-1900,1-1,19), new Time(15,30,0), doc.getSpecialization(), false);
		medicalRecords = new  ArrayList<MedicalRecordBean>();
		medicalRecord = new MedicalRecordBean();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		bookings = null;
		booking = null;
		patient2 = null;
		patient = null;
	}

	/**
	 * Test method for {@link model.Bean.PatientBean#PatientBean()}.
	 */
	@Test
	void testPatientBeanEmptyConstructor() {
		patient = new PatientBean();
		assertNotNull(patient);
	}

	/**
	 * Test method for {@link model.Bean.PatientBean#PatientBean(java.lang.String, java.lang.String, java.lang.String, java.sql.Date, java.lang.String, java.lang.String, java.lang.String, java.lang.integer, java.lang.String)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	void testPatientBeanConstructor() {
		patient = new PatientBean("RSSMRO88N75U789K", "Mario", "Rossi", new Date(1998-1900,11-1,24), "Napoli", "Napoli","martina", 435464744, "marioRossi@live.it");
		assertEquals("RSSMRO88N75U789K", patient.getFiscal_code());
		assertEquals("Mario", patient.getUser_name());
		assertEquals("Rossi", patient.getSurname());
		assertEquals(new Date(1998-1900,11-1,24), patient.getBirth_date());
		assertEquals("Napoli", patient.getBirth_place());
		assertEquals("Napoli", patient.getResidence());
		assertEquals("martina", patient.getUser_password());
		assertEquals(435464744, patient.getPhone_number());
		assertEquals("marioRossi@live.it", patient.getEmail());
	}
	
	/**
	 * Test method for {@link model.Bean.PatientBean#PatientBean(java.lang.String, java.lang.String, java.lang.String, java.sql.Date, java.lang.String, java.lang.String, java.lang.integer, java.lang.String)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	void testPatientBeanConstructor2() {
		patient = new PatientBean("RSSMRO88N75U789K", "Mario", "Rossi", new Date(1998-1900,11-1,24), "Napoli", "Napoli", 435464744, "marioRossi@live.it");
		assertEquals("RSSMRO88N75U789K", patient.getFiscal_code());
		assertEquals("Mario", patient.getUser_name());
		assertEquals("Rossi", patient.getSurname());
		assertEquals(new Date(1998-1900,11-1,24), patient.getBirth_date());
		assertEquals("Napoli", patient.getBirth_place());
		assertEquals("Napoli", patient.getResidence());
		assertEquals(435464744, patient.getPhone_number());
		assertEquals("marioRossi@live.it", patient.getEmail());
	}

	/**
	 * Test method for {@link model.Bean.PatientBean#getBookings()}.
	 */
	@Test
	void testGetBookings() {
		bookings = patient2.getBookings();
		assertNotNull(bookings);
	}

	/**
	 * Test method for {@link model.Bean.PatientBean#addBooking(model.Bean.BookingVisitBean)}.
	 */
	@Test
	void testAddBooking() {
		assertFalse(patient2.getBookings().contains(booking));
		patient2.addBooking(booking);
		assertTrue(patient2.getBookings().contains(booking));
	}

	/**
	 * Test method for {@link model.Bean.PatientBean#getMedicalRecords()}.
	 */
	@Test
	void testGetMedicalRecord() {
		medicalRecords = patient2.getMedicalRecords();
		assertNotNull(medicalRecords);
	}

	/**
	 * Test method for {@link model.Bean.PatientBean#addMedicalRecord(model.Bean.MedicalRecordBean)}.
	 */
	@Test
	void testAddMedicalRecord() {
		patient2.addMedicalRecord(medicalRecord);
		assertEquals(medicalRecord, patient2.getMedicalRecords().get(patient2.getMedicalRecords().indexOf(medicalRecord)));
	}

}
