/**
 * 
 */
package model.Bean;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.Date;
import java.sql.Time;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Tamburello Martina
 *
 */
class VisitTimetableBeanTest {

	VisitTimetableBean visitTimetable;
	DoctorBean doctor;

	/**
	 * @throws java.lang.Exception
	 */
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		doctor = new DoctorBean("VRDLGI88O09P789F", "Luigi", "Verdi", "luigi@checkUp.it", "oculistica");
		visitTimetable = new VisitTimetableBean(doctor.getFiscal_code()+"/"+new Date(2021-1900, 2-1, 7)+"/"+ new Time(15,00,00).toString().substring(0,5), doctor, new Time(15,00,00), new Date(2021-1900, 2-1, 7), 30, true);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		doctor = null;
		visitTimetable = null;
	}

	/**
	 * Test method for {@link model.Bean.VisitTimetableBean#VisitTimetableBean()}.
	 */
	@Test
	void testVisitTimetableBeanEmptyConstructor() {
		visitTimetable = new VisitTimetableBean();
		assertNotNull(visitTimetable);
	}

	/**
	 * Test method for {@link model.Bean.VisitTimetableBean#VisitTimetableBean(java.lang.String, model.Bean.DoctorBean, java.sql.Time, java.sql.Date, java.lang.integer, java.lang.Boolean)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	void testVisitTimetableBeanConstructor() {
		visitTimetable = new VisitTimetableBean(doctor.getFiscal_code()+"/"+new Date(2021-1900, 2-1, 7)+"/"+ new Time(15,00,00).toString().substring(0,5), doctor, new Time(15,00,00), new Date(2021-1900, 2-1, 7), 30, true);
		assertEquals(doctor.getFiscal_code()+"/"+new Date(2021-1900, 2-1, 7)+"/"+ new Time(15,00,00).toString().substring(0,5), visitTimetable.getTimetable_code());
		assertEquals(doctor, visitTimetable.getDoctor());
		assertEquals(new Time(15,00,00), visitTimetable.getHour_visit());
		assertEquals(new Date(2021-1900, 2-1, 7), visitTimetable.getDate_visit());
		assertEquals(30, visitTimetable.getDuration());
		assertTrue(visitTimetable.isAvailability());
	}
	
	
	/**
	 * Test method for {@link model.Bean.VisitTimetableBean#VisitTimetableBean(model.Bean.DoctorBean, java.sql.Time, java.sql.Date, java.lang.integer, java.lang.Boolean)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	void testVisitTimetableBeanConstructor2() {
		visitTimetable = new VisitTimetableBean(doctor, new Time(15,00,00), new Date(2021-1900, 2-1, 7), 30, true);
		assertEquals(doctor, visitTimetable.getDoctor());
		assertEquals(new Time(15,00,00), visitTimetable.getHour_visit());
		assertEquals(new Date(2021-1900, 2-1, 7), visitTimetable.getDate_visit());
		assertEquals(30, visitTimetable.getDuration());
		assertTrue(visitTimetable.isAvailability());
	}

	/**
	 * Test method for {@link model.Bean.VisitTimetableBean#getTimetable_code()}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	void testGetTimetable_code() {
		String timetable_code = visitTimetable.getTimetable_code();
		assertEquals(doctor.getFiscal_code()+"/"+new Date(2021-1900, 2-1, 7)+"/"+ new Time(15,00,00).toString().substring(0,5), timetable_code);
	}

	/**
	 * Test method for {@link model.Bean.VisitTimetableBean#setTimetable_code(java.lang.String)}.
	 */
	@Test
	void testSetTimetable_code() {
		visitTimetable.setTimetable_code("AAABBB");
		assertEquals("AAABBB", visitTimetable.getTimetable_code());
	}

	/**
	 * Test method for {@link model.Bean.VisitTimetableBean#getDoctor()}.
	 */
	@Test
	void testGetDoctor() {
		DoctorBean doc2 = visitTimetable.getDoctor();
		assertEquals(doctor, doc2);
	}

	/**
	 * Test method for {@link model.Bean.VisitTimetableBean#setDoctor(model.Bean.DoctorBean)}.
	 */
	@Test
	void testSetDoctor() {
		visitTimetable.setDoctor(doctor);
		assertEquals(doctor, visitTimetable.getDoctor());
	}

	/**
	 * Test method for {@link model.Bean.VisitTimetableBean#getHour_visit()}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	void testGetHour_visit() {
		Time hour_visit = visitTimetable.getHour_visit();
		assertEquals(new Time(15,00,00), hour_visit);
	}

	/**
	 * Test method for {@link model.Bean.VisitTimetableBean#setHour_visit(java.sql.Time)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	void testSetHour_visit() {
		visitTimetable.setHour_visit(new Time(15,00,00));
		assertEquals(new Time(15,00,00), visitTimetable.getHour_visit());
	}

	/**
	 * Test method for {@link model.Bean.VisitTimetableBean#getDate_visit()}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	void testGetDate_visit() {
		Date date = visitTimetable.getDate_visit();
		assertEquals(new Date(2021-1900, 2-1, 7), date);
	}

	/**
	 * Test method for {@link model.Bean.VisitTimetableBean#setDate_visit(java.sql.Date)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	void testSetDate_visit() {
		visitTimetable.setDate_visit(new Date(2021-1900, 2-1, 7));
		assertEquals(new Date(2021-1900, 2-1, 7), visitTimetable.getDate_visit());
	}

	/**
	 * Test method for {@link model.Bean.VisitTimetableBean#getDuration()}.
	 */
	@Test
	void testGetDuration() {
		int duration = visitTimetable.getDuration();
		assertEquals(30, duration);
	}

	/**
	 * Test method for {@link model.Bean.VisitTimetableBean#setDuration(java.lang.integer)}.
	 */
	@Test
	void testSetDuration() {
		visitTimetable.setDuration(20);
		assertEquals(20, visitTimetable.getDuration());
	}

	/**
	 * Test method for {@link model.Bean.VisitTimetableBean#isAvailability()}.
	 */
	@Test
	void testIsAvailability() {
		boolean isAvailability = visitTimetable.isAvailability();
		assertTrue(isAvailability);
	}
	
	/**
	 * Test method for {@link model.Bean.VisitTimetableBean#setAvailability(java.lang.Boolean)}.
	 */
	@Test
	void testSetAvailability() {
		visitTimetable.setAvailability(false);
		assertFalse(visitTimetable.isAvailability());
	}

}
