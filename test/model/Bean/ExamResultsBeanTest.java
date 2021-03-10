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
class ExamResultsBeanTest {

	ExamResultBean exam_result;
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
		exam_result = new ExamResultBean("BBB12","000000", new Date(2021-1900, 2-1, 7), doc, patient, "exam1", "note", "path_File", false);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		exam_result = null;
	}

	/**
	 * Test method for {@link model.Bean.ExamResultsBean#ExamResultsBean()}.
	 */
	@Test
	void testExamResultBeanEmptyConstructor() {
		exam_result = new ExamResultBean();
		assertNotNull(exam_result);
	}

	/**
	 * Test method for {@link model.Bean.ExamResultsBean#ExamResultsBean(java.lang.String, java.lang.String, java.sql.Date, model.Bean.DoctorBean, model.Bean.PatientBean, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	void testExamResultBeanConstructor() {
		exam_result = new ExamResultBean("BBB12", "000000", new Date(2021-1900, 2-1, 7), doc, patient, "exam1", "note", "path_File", false);
		assertEquals("BBB12", exam_result.getReport_code());
		assertEquals("000000", exam_result.getMedical_record_code());
		assertEquals(new Date(2021-1900, 2-1, 7), exam_result.getInsertion_date());
		assertEquals(doc, exam_result.getDoctor());
		assertEquals(patient, exam_result.getPatient());
		assertEquals("note", exam_result.getNote());
		assertEquals("path_File", exam_result.getReport_file());
		assertFalse(exam_result.isRevised());
	}

	/**
	 * Test method for {@link model.Bean.ExamResultsBean#isRevised()}.
	 */
	@Test
	void testIsRevised() {
		Boolean isRevised = exam_result.isRevised();
		assertFalse(isRevised);
	}

	/**
	 * Test method for {@link model.Bean.ExamResultsBean#setRevised(java.lang.Boolean)}.
	 */
	@Test
	void testSetRevised() {
		exam_result.setRevised(true);
		assertTrue(exam_result.isRevised());
	}

	/**
	 * Test method for {@link model.Bean.ExamResultsBean#getNote()}.
	 */
	@Test
	void testGetNote() {
		String note = exam_result.getNote();
		assertEquals("note", note);
	}

	/**
	 * Test method for {@link model.Bean.ExamResultsBean#setNote(java.lang.String)}.
	 */
	@Test
	void testSetNote() {
		exam_result.setNote("note");
		assertEquals("note", exam_result.getNote());
	}

	/**
	 * Test method for {@link model.Bean.ExamResultsBean#getReport_file()}.
	 */
	@Test
	void testGetReport_file() {
		String report_file = exam_result.getReport_file();
		assertEquals("path_File", report_file);
	}

	/**
	 * Test method for {@link model.Bean.ExamResultsBean#setReport_file(java.lang.String)}.
	 */
	@Test
	void testSetReport_file() {
		exam_result.setReport_file("path.file");
		assertEquals("path.file", exam_result.getReport_file());
	}

}
