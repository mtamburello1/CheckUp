package model.Bean;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReportBeanTest {

	ReportBean report;
	DoctorBean doc;
	PatientBean patient;
	
	/**
	 * @throws java.lang.Exception
	 */
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		doc = new DoctorBean("RSSMRO78Y87U345O", "Mario" , "Rossi", "rossi@checkUp.it", "oculistica");
		patient = new PatientBean ("VRDLGI80I09O098P", "Luigi", "Verdi", new Date(1980-1900, 3-1, 3), "Salerno", "Salerno", "martina", 21345242, "LuigiVerdi@hotmail.it");
		report = new ReportBean("BBB12","AAABBB",new Date(2021-1900, 3-1, 3), doc, patient);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		doc = null;
		patient = null;
		report = null;
	}

	/**
	 * Test method for {@link model.Bean.ReportBean#ReportBean()}.
	 */
	@Test
	void testReportBeanEmptyConstructor() {
		report = new ReportBean();
		assertNotNull(report);
	}

	/**
	 * Test method for {@link model.Bean.ReportBean#ReportBean(java.lang.String, java.lang.String, java.sql.Date, model.Bean.DoctorBean, model.Bean.PatientBean)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	void testReportBeanConstructor() {
		report = new ReportBean("BBB12", "AAABBB",new Date(2021-1900, 3-1, 3), doc, patient);
		assertEquals("BBB12", report.getReport_code());
		assertEquals("AAABBB", report.getMedical_record_code());
		assertEquals(new Date(2021-1900, 3-1, 3), report.getInsertion_date());
		assertEquals(doc, report.getDoctor());
		assertEquals(patient, report.getPatient());
	}

	/**
	 * Test method for {@link model.Bean.ReportBean#getReport_code()}.
	 */
	@Test
	void testGetReport_code() {
		String report_code = report.getReport_code();
		assertEquals("BBB12", report_code);
	}

	/**
	 * Test method for {@link model.Bean.ReportBean#setReport_code(java.lang.String)}.
	 */
	@Test
	void testSetReport_code() {
		report.setReport_code("BBB12");
		assertEquals("BBB12", report.getReport_code());
	}
	
	/**
	 * Test method for {@link model.Bean.ReportBean#getMedical_record_code()}.
	 */
	@Test
	void testGetMedical_record_code() {
		String medical_record_code = report.getMedical_record_code();
		assertEquals("AAABBB", medical_record_code);
	}

	/**
	 * Test method for {@link model.Bean.ReportBean#setMedical_record_code(java.lang.String)}.
	 */
	@Test
	void testSetMedical_record_code() {
		report.setMedical_record_code("BBBAAA");
		assertEquals("BBBAAA", report.getMedical_record_code());
	}

	/**
	 * Test method for {@link model.Bean.ReportBean#getInsertion_date()}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	void testGetInsertion_date() {
		Date date = report.getInsertion_date();
		assertEquals(new Date(2021-1900, 3-1, 3), date);
	}

	/**
	 * Test method for {@link model.Bean.ReportBean#setInsertion_date(java.sql.Date)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	void testSetInsertion_date() {
		report.setInsertion_date(new Date(2021-1900, 3-1, 3));
		assertEquals(new Date(2021-1900, 3-1, 3), report.getInsertion_date());
	}

	/**
	 * Test method for {@link model.Bean.ReportBean#getDoctor()}.
	 */
	@Test
	void testGetDoctor() {
		DoctorBean doc2 = report.getDoctor();
		assertEquals(doc, doc2);
	}
	
	/**
	 * Test method for {@link model.Bean.ReportBean#setDoctor(model.Bean.DoctorBean)}.
	 */
	@Test
	void testSetDoctor() {
		report.setDoctor(doc);
		assertEquals(doc, report.getDoctor());
	}

	/**
	 * Test method for {@link model.Bean.ReportBean#getPatient()}.
	 */
	@Test
	void testGetPatient() {
		PatientBean patient2 = report.getPatient();
		assertEquals(patient, patient2);
	}
	
	/**
	 * Test method for {@link model.Bean.ReportBean#setPatient(model.Bean.PatientBean)}.
	 */
	@Test
	void testSetPatient() {
		report.setPatient(patient);
		assertEquals(patient, report.getPatient());
	}

}
