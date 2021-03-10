/**
 * 
 */
package model.Database;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Bean.BookingVisitBean;
import model.Bean.DoctorBean;
import model.Bean.PatientBean;
import model.Dao.BookingDAO;

/**
 * @author Tamburello Martina
 * 
 */
class DbBookingDAOTest {

	static BookingVisitBean bookingToInsert;
	static BookingVisitBean bookingToDelete;
	static BookingVisitBean bookingToReturn;
	BookingDAO bookingDAO;
	static DoctorBean doctor;
	static PatientBean patient;
	ArrayList<BookingVisitBean> bookings;
	String booking_code;
	static BookingDAO bDAO;

	/**
	 * @throws java.lang.Exception
	 */
	@SuppressWarnings("deprecation")
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		doctor = new DoctorBean("VRDLGI88O09P789F", "Luigi", "Verdi", "luigi@checkUp.it", "oculistica");
		patient = new PatientBean("RSSMRO88N75U789K", "Mario", "Rossi", new Date(1998-1900,11-1,24), "Napoli", "Napoli","martina", 435464744, "marioRossi@live.it");
		bookingToDelete = new BookingVisitBean(patient, doctor, new Date(2021-1900,5-1,19), new Time(16,30,0), doctor.getSpecialization(), false);
		bookingToInsert = new BookingVisitBean(patient, doctor, new Date(2021-1900,5-1,24), new Time(16,30,0), doctor.getSpecialization(), false);
		bDAO = new DbBookingDAO();
		bDAO.insertBooking(bookingToDelete);
		bookingToReturn = new BookingVisitBean(patient, doctor, new Date(2021-1900,5-1,28), new Time(10,30,0), doctor.getSpecialization(), false);
		bDAO.insertBooking(bookingToReturn);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		bookingDAO = new DbBookingDAO();
		bookings = new ArrayList<BookingVisitBean>();
		booking_code = "RSSMRO88N75U789K/oculistica/VRDLGI88O09P789F/2021-05-28/10:30";
	}


	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		bookingDAO.deleteBooking(bookingToInsert.getBooking_code());
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		bDAO.deleteBooking(bookingToDelete.getBooking_code());
		bDAO.deleteBooking(bookingToReturn.getBooking_code());
	}
	
	/**
	 * Test method for {@link model.DbBookingDAO#InsertBooking(model.Bean.BookingVisitBean)}.
	 */
	@Test
	void testInsertBooking() {
		bookingDAO.insertBooking(bookingToInsert);
		assertNotNull(bookingDAO.returnBookingByKey(bookingToInsert.getBooking_code()));
	}
	
	
	/**
	 * Test method for {@link model.DbBookingDAO#ReturnBookingByKey(java.lang.String)}.
	 */
	@Test
	void testReturnBookingByKey() {
		assertNotNull(bookingDAO.returnBookingByKey(booking_code));
	}
	
	/**
	 * Test method for {@link model.DbBookingDAO#ReturnBookingByKey(java.lang.String)}.
	 */
	@Test
	void testReturnBookingByKey_notExists() {
		assertNull(bookingDAO.returnBookingByKey("AAAAA"));
	}


	/**
	 * Test method for {@link model.DbBookingDAO#DeleteBooking(model.Bean.BookingVisitBean)}.
	 */
	@Test
	void testDeleteBooking() {
		boolean deleted = bookingDAO.deleteBooking(bookingToDelete.getBooking_code());
		assertTrue(deleted);
		assertNull(bookingDAO.returnBookingByKey(bookingToDelete.getBooking_code()));
	}

	/**
	 * Test method for {@link model.DbBookingDAO#getBookingList(model.Bean.PatientBean)}.
	 */
	@Test
	void testGetBookingList() {
		bookings = bookingDAO.getBookingList(patient);
		assertNotNull(bookings);
		for (BookingVisitBean b : bookings) {
			assertTrue(b.getPatient().getFiscal_code().equals(patient.getFiscal_code()));
		}
	}

}
