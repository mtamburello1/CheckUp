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
class BookingVisitBeanTest {

	BookingVisitBean booking;
	BookingVisitBean booking2;
	DoctorBean doc;
	PatientBean patient;
	
	/**
	 * @throws java.lang.Exception
	 */
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		doc = new DoctorBean("VRDLGI88O09P789F", "Luigi", "Verdi", "luigi@checkUp.it", "oculistica");
		patient = new PatientBean("RSSMRO88N75U789K", "Mario", "Rossi", new Date(1998-1900,11-1,24), "Napoli", "Napoli","martina", 435464744, "marioRossi@live.it");
		booking = new BookingVisitBean(patient, doc, new Date(2021-1900,1-1,20), new Time(10,30,00), "oculistica", true);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		doc = null;
		booking = null;
		patient = null;
	}

	/**
	 * Test method for {@link model.Bean.BookingVisitBean#BookingVisitBean()}.
	 */
	@Test
	void testBookingVisitBeanEmptyConstructor() {
		booking2 = new BookingVisitBean();
		assertNotNull(booking2);
	}

	/**
	 * Test method for {@link model.Bean.BookingVisitBean#BookingVisitBean(model.Bean.PatientBean, model.Bean.DoctorBean, java.sql.Date, java.sql.Time, java.lang.String, java.lang.Boolean)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	void testBookingVisitBeanConstructor() {
		booking = new BookingVisitBean(patient, doc, new Date(2021-1900,3-1,24), new Time(16,30,00), "oculistica", false);
		assertEquals("RSSMRO88N75U789K/oculistica/VRDLGI88O09P789F/2021-03-24/16:30", booking.getBooking_code());
		assertEquals(patient, booking.getPatient());
		assertEquals(doc, booking.getDoctor());
		assertEquals(new Date(2021-1900,3-1,24), booking.getBooking_day());
		assertEquals(new Time(16,30,00), booking.getBooking_hour());
		assertEquals("oculistica", booking.getBooking_type());
		assertFalse(booking.isCarried_out());
	}

	/**
	 * Test method for {@link model.Bean.BookingVisitBean#BookingVisitBean(java.lang.String, model.Bean.PatientBean, model.Bean.DoctorBean, java.sql.Date, java.sql.Time, java.lang.String, java.lang.Boolean)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	void testBookingVisitBeanConstructor2() {
		booking = new BookingVisitBean("AAABBB", patient, doc, new Date(2021-1900,3-1,24), new Time(16,30,00), "oculistica", true);
		assertEquals("AAABBB", booking.getBooking_code());
		assertEquals(patient, booking.getPatient());
		assertEquals(doc, booking.getDoctor());
		assertEquals(new Date(2021-1900,3-1,24), booking.getBooking_day());
		assertEquals(new Time(16,30,00), booking.getBooking_hour());
		assertEquals("oculistica", booking.getBooking_type());
		assertTrue(booking.isCarried_out());
	}


	/**
	 * Test method for {@link model.Bean.BookingVisitBean#getBooking_code()}.
	 */
	@Test
	void testGetBooking_code() {
		String booking_code = booking.getBooking_code();
		assertEquals("RSSMRO88N75U789K/oculistica/VRDLGI88O09P789F/2021-01-20/10:30", booking_code);
	}

	/**
	 * Test method for {@link model.Bean.BookingVisitBean#setBooking_code(java.lang.String)}.
	 */
	@Test
	void testSetBooking_code() {
		booking.setBooking_code("BBBAAA");
		assertEquals("BBBAAA", booking.getBooking_code());
	}

	/**
	 * Test method for {@link model.Bean.BookingVisitBean#getDoctor()}.
	 */
	@Test
	void testGetDoctor() {
		DoctorBean doc2 = booking.getDoctor();
		assertEquals(doc, doc2);
	}

	/**
	 * Test method for {@link model.Bean.BookingVisitBean#setDoctor(model.Bean.DoctorBean)}.
	 */
	@Test
	void testSetDoctor() {
		booking.setDoctor(doc);
		assertEquals(doc, booking.getDoctor());
	}

	/**
	 * Test method for {@link model.Bean.BookingVisitBean#getPatient()}.
	 */
	@Test
	void testGetPatient() {
		PatientBean patient2 = booking.getPatient();
		assertEquals(patient, patient2);
	}

	/**
	 * Test method for {@link model.Bean.BookingVisitBean#setPatient(model.Bean.PatientBean)}.
	 */
	@Test
	void testSetPatient() {
		booking.setPatient(patient);
		assertEquals(patient, booking.getPatient());
	}

	/**
	 * Test method for {@link model.Bean.BookingVisitBean#getBooking_day()}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	void testGetBooking_day() {
		Date date = booking.getBooking_day();
		assertEquals(new Date(2021-1900,1-1,20), date);
	}

	/**
	 * Test method for {@link model.Bean.BookingVisitBean#setBooking_day(java.sql.Date)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	void testSetBooking_day() {
		booking.setBooking_day(new Date(2021-1900,3-1,24));
		assertEquals(new Date(2021-1900,3-1,24), booking.getBooking_day());
	}

	/**
	 * Test method for {@link model.Bean.BookingVisitBean#getBooking_hour()}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	void testGetBooking_hour() {
		Time booking_hour = booking.getBooking_hour();
		assertEquals(new Time(10,30,00), booking_hour);
	}

	/**
	 * Test method for {@link model.Bean.BookingVisitBean#setBooking_hour(java.sql.Time)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	void testSetBooking_hour() {
		booking.setBooking_hour(new Time(16,30,00));
		assertEquals(new Time(16,30,00), booking.getBooking_hour());
	}

	/**
	 * Test method for {@link model.Bean.BookingVisitBean#getBooking_type()}.
	 */
	@Test
	void testGetBooking_type() {
		String booking_type = booking.getBooking_type();
		assertEquals("oculistica", booking_type);
	}

	/**
	 * Test method for {@link model.Bean.BookingVisitBean#setBooking_type(java.lang.String)}.
	 */
	@Test
	void testSetBooking_type() {
		booking.setBooking_type("allergologica");
		assertEquals("allergologica", booking.getBooking_type());
	}

	/**
	 * Test method for {@link model.Bean.BookingVisitBean#isCarried_out()}.
	 */
	@Test
	void testIsCarried_out() {
		boolean isCarried_out = booking.isCarried_out();
		assertTrue(isCarried_out);
	}

	/**
	 * Test method for {@link model.Bean.BookingVisitBean#setCarried_out(boolean)}.
	 */
	@Test
	void testSetCarried_out() {
		booking.setCarried_out(true);
		assertTrue(booking.isCarried_out());
	}

}
