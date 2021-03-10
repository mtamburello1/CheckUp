/**
 * 
 */
package model.Bean;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Tamburello Martina
 *
 */
class DiagnosisBeanTest {

	DiagnosisBean diagnosis;
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
		diagnosis = new DiagnosisBean("BBB12","000000", new Date(2021-1900, 2-1, 7), doc, patient, "descrizione visita", "motivo visita");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		doc = null;
		patient = null;
		diagnosis = null;
		
	}

	/**
	 * Test method for {@link model.Bean.DiagnosisBean#DiagnosisBean()}.
	 */
	@Test
	void testDiagnosisBeanEmptyConstructor() {
		diagnosis = new DiagnosisBean();
		assertNotNull(diagnosis);
	}

	/**
	 * Test method for {@link model.Bean.DiagnosisBean#DiagnosisBean(java.lang.String, java.sql.Date, model.Bean.UserBean, model.Bean.UserBean, java.lang.String, java.lang.String)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	void testDiagnosisBeanConstructor() {
		diagnosis = new DiagnosisBean("BBB12" ,"000000", new Date(2021-1900, 2-1, 7), doc, patient, "descrizione visita", "motivo visita");
		assertEquals("BBB12", diagnosis.getReport_code());
		assertEquals("000000", diagnosis.getMedical_record_code());
		assertEquals(new Date(2021-1900, 2-1, 7), diagnosis.getInsertion_date());
		assertEquals(doc, diagnosis.getDoctor());
		assertEquals(patient, diagnosis.getPatient());
		assertEquals("descrizione visita", diagnosis.getDiagnosis_description());
		assertEquals("motivo visita", diagnosis.getReason_for_the_visit());
	}

	/**
	 * Test method for {@link model.Bean.DiagnosisBean#getDiagnosis_description()}.
	 */
	@Test
	void testGetDiagnosis_description() {
		String description = diagnosis.getDiagnosis_description();
		assertEquals("descrizione visita", description);
	}

	/**
	 * Test method for {@link model.Bean.DiagnosisBean#setDiagnosis_description(java.lang.String)}.
	 */
	@Test
	void testSetDiagnosis_description() {
		diagnosis.setDiagnosis_description("descrizione della visita");
		assertEquals( "descrizione della visita" , diagnosis.getDiagnosis_description());
	}

	/**
	 * Test method for {@link model.Bean.DiagnosisBean#getReason_for_the_visit()}.
	 */
	@Test
	void testGetReason_for_the_visit() {
		String reason_for_the_visit = diagnosis.getReason_for_the_visit();
		assertEquals("motivo visita", reason_for_the_visit);
	}

	/**
	 * Test method for {@link model.Bean.DiagnosisBean#setReason_for_the_visit(java.lang.String)}.
	 */
	@Test
	void testSetReason_for_the_visit() {
		diagnosis.setReason_for_the_visit("motivo della visita");
		assertEquals( "motivo della visita" , diagnosis.getReason_for_the_visit());
	}

}
