/**
 * 
 */
package model.Database;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Bean.DoctorBean;
import model.Bean.VisitTimetableBean;
import model.Dao.VisitTimetableDAO;

/**
 * @author Tamburello Martina
 *
 */
class DbVisitTimetableDAOTest {

	VisitTimetableDAO visitTimetableDAO;
	static String timetable_code;
	ArrayList<DoctorBean> doctors;
	String booking_code;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		doctors = new ArrayList<DoctorBean>();
		timetable_code = "VRDLGI88O09P789F/2021-01-18/15:30";
		visitTimetableDAO = new DbVisitTimetableDAO();
		booking_code = "RSSMRO88N75U789K/oculistica/VRDLGI88O09P789F/2021-02-19/10:00";
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		VisitTimetableDAO vtDAO = new DbVisitTimetableDAO();
		vtDAO.updateVisitTimetable(timetable_code, true);
	}

	/**
	 * Test method for {@link model.DbVisitTimetableDAO#getDoctorsAndTimetables(java.lang.String)}.
	 */
	@Test
	void testGetDoctorsAndTimetables() {
		String specialization = "oculistica";
		doctors = visitTimetableDAO.getDoctorsAndTimetables(specialization);
		assertNotNull(doctors);
		for(DoctorBean d : doctors) {
			assertTrue(d.getSpecialization().equals(specialization));
		}
	}

	/**
	 * Test method for {@link model.DbVisitTimetableDAO#getDoctorsAndTimetables(java.lang.String)}.
	 */
	@Test
	void testGetDoctorsAndTimetables_SpecializationNotExists() {
		String specialization = "AAA";
		doctors = visitTimetableDAO.getDoctorsAndTimetables(specialization);
		assertTrue(doctors.size()==0);
	}

	/**
	 * Test method for {@link model.DbVisitTimetableDAO#ReturnVisitTimetableByKey(java.lang.String)}.
	 */
	@Test
	final void testReturnVisitTimetableByKey() {
		VisitTimetableBean vt= visitTimetableDAO.returnVisitTimetableByKey(timetable_code);
		assertEquals(timetable_code, vt.getTimetable_code());
	}

	/**
	 * Test method for {@link model.DbVisitTimetableDAO#ReturnVisitTimetableByKey(java.lang.String)}.
	 */
	@Test
	final void testReturnVisitTimetableByKey_notExists() {
		VisitTimetableBean vt= visitTimetableDAO.returnVisitTimetableByKey("AAAA");
		assertNull(vt);
	}

	/**
	 * Test method for {@link model.DbVisitTimetableDAO#UpdateVisitTimetable(java.lang.String, java.lang.Boolean)}.
	 */
	@Test
	final void testUpdateVisitTimetable() {
		visitTimetableDAO.updateVisitTimetable(timetable_code, false);
		VisitTimetableBean vt= visitTimetableDAO.returnVisitTimetableByKey(timetable_code);
		assertFalse(vt.isAvailability());
	}

	/**
	 * Test method for {@link model.DbVisitTimetableDAO#UpdateVisitTimetable(java.lang.String, java.lang.Boolean)}.
	 */
	@Test
	final void testCalculateTimetable_code() {
		String vt_code = visitTimetableDAO.calculateTimetable_code(booking_code);
		assertEquals("VRDLGI88O09P789F/2021-02-19/10:00", vt_code);
	}

}
