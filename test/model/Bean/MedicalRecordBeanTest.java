/**
 * 
 */
package model.Bean;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Tamburello Martina
 *
 */
class MedicalRecordBeanTest {

	MedicalRecordBean medicalRecord;
	ArrayList<ReportBean> reports;
	ReportBean report;
	DoctorBean doc;
	PatientBean patient;
	
	/**
	 * @throws java.lang.Exception
	 */
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		reports = new ArrayList<ReportBean>();
		doc = new DoctorBean("RSSMRO78Y87U345O", "Mario" , "Rossi", "rossi@checkUp.it", "oculistica");
		patient = new PatientBean ("VRDLGI80I09O098P", "Luigi", "Verdi", new Date(1980-1900, 3-1, 3), "Salerno", "Salerno", "martina", 21345242, "LuigiVerdi@hotmail.it");
		medicalRecord = new MedicalRecordBean();
		report = new ReportBean("BBB12", "AAABBB",new Date(2021-1900, 3-1, 3), doc, patient);
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		medicalRecord = null;
	}

	/**
	 * Test method for {@link model.Bean.MedicalRecordBean#MedicalRecordBean()}.
	 */
	@Test
	void testMedicalRecordBeanEmptyConstructor() {
		medicalRecord = new MedicalRecordBean();
		assertNotNull(medicalRecord);
	}

	/**
	 * Test method for {@link model.Bean.MedicalRecordBean#add(model.Bean.ReportBean)}.
	 */
	@Test
	void testAddReport() {
		assertFalse(medicalRecord.getReports().contains(report));
		medicalRecord.addReport(report);
		assertTrue(medicalRecord.getReports().contains(report));
	}

	/**
	 * Test method for {@link model.Bean.MedicalRecordBean#getReport()}.
	 */
	@Test
	void testGetReport() {
		reports = medicalRecord.getReports();
		assertNotNull(reports);
	}


}
