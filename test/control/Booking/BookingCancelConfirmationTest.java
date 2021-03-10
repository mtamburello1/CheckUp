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

import org.junit.jupiter.api.BeforeAll;
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
class BookingCancelConfirmationTest {

	private static BookingDAO bookingDAO;
	private static BookingVisitBean booking;
	private BookingCancelConfirmation bookingCancelConfirmation;
	private HttpServletRequest mockedRequest;
	private HttpServletResponse mockedResponse;
	private HttpSession mockedSession;
	private static PatientBean p;
	
	/**
	 * @throws java.lang.Exception
	 */
	@SuppressWarnings("deprecation")
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		bookingDAO = new DbBookingDAO();
		p = new PatientBean();
		p.setFiscal_code("RSSMRO88N75U789K");
		DoctorBean doc = new DoctorBean();
		doc.setFiscal_code("VRDLGI88O09P789F");
		doc.setSpecialization("oculistica");
		booking = new BookingVisitBean(p, doc, new Date(2021-1900, 1-1, 22), new Time(18, 00, 00), doc.getSpecialization(), false);
		bookingDAO.insertBooking(booking);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		bookingCancelConfirmation = new BookingCancelConfirmation();
		mockedRequest = Mockito.mock(HttpServletRequest.class);
		mockedResponse = Mockito.mock(HttpServletResponse.class);
		mockedSession = Mockito.mock(HttpSession.class);
		Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
	}


	/**
	 * Test method for {@link control.Booking.BookingCancelConfirmation#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Test
	final void testDoPostSuccessfull() throws ServletException, IOException {
		Mockito.when(mockedSession.getAttribute("user")).thenReturn(p);
		Mockito.when(mockedRequest.getParameter("booking_code")).thenReturn(booking.getBooking_code());
		
		bookingCancelConfirmation.doPost(mockedRequest, mockedResponse);
	
		Mockito.verify(mockedResponse).sendRedirect("/CheckUp/Patient/Booking/BookingDeleted.jsp");
	}
	

	/**
	 * Test method for {@link control.Booking.BookingCancelConfirmation#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Test
	final void testDoPostUserNotLogged() throws ServletException, IOException {
		Mockito.when(mockedSession.getAttribute("user")).thenReturn(null);

		bookingCancelConfirmation.doPost(mockedRequest, mockedResponse);

		Mockito.verify(mockedResponse).sendRedirect("Shared/SessionTimeOut.jsp");

	}

}
