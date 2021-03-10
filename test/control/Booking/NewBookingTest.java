/**
 * 
 */
package control.Booking;


import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import model.Bean.BookingVisitBean;
import model.Bean.DoctorBean;
import model.Bean.PatientBean;
import model.Dao.BookingDAO;
import model.Database.DbBookingDAO;

/**
 * @author Tamburello Martina
 *
 */
class NewBookingTest {

	private NewBooking newBooking;
	private HttpServletRequest mockedRequest;
	private HttpServletResponse mockedResponse;
	private HttpSession mockedSession;
	private PatientBean patient;
	
	/**
	 * @throws java.lang.Exception
	 */
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		newBooking = new NewBooking();
		patient = new PatientBean("RSSMRO88N75U789K", "Mario", "Rossi", new Date(1998-1900,11-1,24), "Napoli", "Napoli","martina", 435464744, "marioRossi@live.it");
		mockedRequest = Mockito.mock(HttpServletRequest.class);
		mockedResponse = Mockito.mock(HttpServletResponse.class);
		mockedSession = Mockito.mock(HttpSession.class);
		
	
	}

	/**
	 * @throws java.lang.Exception
	 */
	@SuppressWarnings("deprecation")
	@AfterEach
	void tearDown() throws Exception {
		BookingDAO bookingDAO = new DbBookingDAO();
		PatientBean patient = new PatientBean();
		patient.setFiscal_code("RSSMRO88N75U789K");
		DoctorBean doctor = new DoctorBean();
		doctor.setFiscal_code("VRDLGI88O09P789F");
		BookingVisitBean booking = new BookingVisitBean(patient, doctor, new Date(2021-1900, 9-1, 10), new Time(10, 30, 00), "oculistica", false);
		bookingDAO.deleteBooking(booking.getBooking_code());
	}

	/**
	 * Test method for {@link control.NewBooking#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Test
	void testDoPostSuccessfull() throws IOException, ServletException {
		Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
		Mockito.when(mockedSession.getAttribute("user")).thenReturn(patient);
		Mockito.when(mockedRequest.getParameter("specialization")).thenReturn("oculistica");
		Mockito.when(mockedRequest.getParameter("fiscal_code")).thenReturn("VRDLGI88O09P789F");
		Mockito.when(mockedRequest.getParameter("date")).thenReturn("set 10, 2021");
		Mockito.when(mockedRequest.getParameter("hours")).thenReturn("10:30:00");
		
		newBooking.doPost(mockedRequest, mockedResponse);
		
		Mockito.verify(mockedResponse).sendRedirect("/CheckUp/Patient/Booking/BookingConfirmed.jsp");
	
	}
	
	
	/**
	 * Test method for {@link control.NewBooking#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Test
	void testDoPostUserNotLogged() throws IOException, ServletException {
		Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
		Mockito.when(mockedSession.getAttribute("user")).thenReturn(null);
		
		newBooking.doPost(mockedRequest, mockedResponse);
		
		Mockito.verify(mockedResponse).sendRedirect("Shared/SessionTimeOut.jsp");
		
	}
	
	/**
	 * Test method for {@link control.NewBooking#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Test
	void testDoPostMissingValues() throws IOException, ServletException {
		Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
		Mockito.when(mockedSession.getAttribute("user")).thenReturn(patient);
		Mockito.when(mockedRequest.getParameter("specialization")).thenReturn(null);
		Mockito.when(mockedRequest.getParameter("fiscal_code")).thenReturn(null);
		Mockito.when(mockedRequest.getParameter("date")).thenReturn(null);
		Mockito.when(mockedRequest.getParameter("hours")).thenReturn(null);
		
		newBooking.doPost(mockedRequest, mockedResponse);
		
		Mockito.verify(mockedResponse).sendRedirect("BookingForm");
		
	}

}
