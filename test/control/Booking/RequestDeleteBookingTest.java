/**
 * 
 */
package control.Booking;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import model.Bean.BookingVisitBean;
import model.Bean.DoctorBean;
import model.Bean.PatientBean;
/**
 * @author Tamburello Martina
 *
 */
class RequestDeleteBookingTest {

	private RequestDeleteBooking requestDeleteBooking;
	private HttpServletRequest mockedRequest;
	private HttpServletResponse mockedResponse;
	private HttpSession mockedSession;
	private RequestDispatcher mockedDispatcher;
	private static PatientBean patient;
	private static DoctorBean doctor;
	private static BookingVisitBean booking;
	
	/**
	 * @throws java.lang.Exception
	 */
	@SuppressWarnings("deprecation")
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		patient = new PatientBean("RSSMRO88N75U789K", "Mario", "Rossi", new Date(1974-1900, 12-1, 20), "aaa", "bbb", 12345, "mario@hotmail.it");
		doctor = new DoctorBean("VRDLGI88O09P789F", "Luigi", "Verdi", "luigi@checkUp.it", "oculistica");
		booking = new BookingVisitBean(patient, doctor, new Date(2021-1900, 3-1,2), new Time(15,30,00), doctor.getSpecialization(), false);
		
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		mockedRequest = Mockito.mock(HttpServletRequest.class);
		mockedResponse = Mockito.mock(HttpServletResponse.class);
		mockedSession = Mockito.mock(HttpSession.class);
		Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
		requestDeleteBooking = new RequestDeleteBooking();
		mockedDispatcher = Mockito.mock(RequestDispatcher.class);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link control.DeleteBooking#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Test
	final void testDoPostSuccessfull() throws ServletException, IOException {

		Mockito.when(mockedSession.getAttribute("user")).thenReturn(patient);
		Mockito.when(mockedRequest.getParameter("doctor_fiscal_code")).thenReturn(booking.getDoctor().getFiscal_code());
		Mockito.when(mockedRequest.getParameter("doctor_surname")).thenReturn(booking.getDoctor().getSurname());
		Mockito.when(mockedRequest.getParameter("doctor_user_name")).thenReturn(booking.getDoctor().getUser_name());
		Mockito.when(mockedRequest.getParameter("booking_date")).thenReturn(booking.getBooking_day().toString());
		Mockito.when(mockedRequest.getParameter("booking_hour")).thenReturn(booking.getBooking_hour().toString());
		Mockito.when(mockedRequest.getParameter("booking_type")).thenReturn(booking.getBooking_type());
		Mockito.when(mockedRequest.getParameter("carried_out")).thenReturn(booking.isCarried_out()+"");
		Mockito.when(mockedRequest.getRequestDispatcher("Patient/Booking/BookingCancelConfirmation.jsp")).thenReturn(mockedDispatcher);
		
		requestDeleteBooking.doPost(mockedRequest, mockedResponse);
		
		Mockito.verify(mockedDispatcher).forward(mockedRequest, mockedResponse);
	}
	
	/**
	 * Test method for {@link control.DeleteBooking#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Test
	final void testDoPostAlreadyCarriedOut() throws ServletException, IOException {
		
		Mockito.when(mockedSession.getAttribute("user")).thenReturn(patient);
		Mockito.when(mockedRequest.getParameter("doctor_fiscal_code")).thenReturn(booking.getDoctor().getFiscal_code());
		Mockito.when(mockedRequest.getParameter("booking_date")).thenReturn(booking.getBooking_day().toString());
		Mockito.when(mockedRequest.getParameter("booking_hour")).thenReturn(booking.getBooking_hour().toString());
		Mockito.when(mockedRequest.getParameter("booking_type")).thenReturn(booking.getBooking_type());
		Mockito.when(mockedRequest.getParameter("carried_out")).thenReturn("true");
		
		requestDeleteBooking.doPost(mockedRequest, mockedResponse);
		
		Mockito.verify(mockedResponse).sendRedirect("/CheckUp/Patient/Booking/Denied.jsp");
	}

	
	/**
	 * Test method for {@link control.DeleteBooking#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Test
	final void testDoPostUserNotLogged() throws ServletException, IOException {
		
		Mockito.when(mockedSession.getAttribute("user")).thenReturn(null);
		
		requestDeleteBooking.doPost(mockedRequest, mockedResponse);
		
		Mockito.verify(mockedResponse).sendRedirect("Shared/SessionTimeOut.jsp");
	}

}
