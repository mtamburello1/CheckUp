/**
 * 
 */
package control.Booking;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import model.Bean.PatientBean;

/**
 * @author Tamburello Martina
 *
 */
class BookingFormTest {

	private HttpServletRequest mockedRequest;
	private HttpServletResponse mockedResponse;
	private HttpSession mockedSession;
	private ServletContext mockedServletContext;
	private RequestDispatcher mockedDispatcher;
	private BookingForm bookingForm;
	private PatientBean patient;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		patient = Mockito.mock(PatientBean.class);
		patient.setFiscal_code("RSSMRO88N75U789K");
		bookingForm = new BookingForm();
		mockedRequest = Mockito.mock(HttpServletRequest.class);
		mockedResponse = Mockito.mock(HttpServletResponse.class);
		mockedSession = Mockito.mock(HttpSession.class);
		mockedServletContext = Mockito.mock(ServletContext.class);
		mockedDispatcher = Mockito.mock(RequestDispatcher.class);
		Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link control.BookingForm#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Test
	final void testDoPostSuccessfull() throws IOException, ServletException {
	
		Mockito.when(mockedSession.getAttribute("user")).thenReturn(patient);
		Mockito.when(mockedRequest.getServletContext()).thenReturn(mockedServletContext);
	    Mockito.when(mockedServletContext.getRequestDispatcher("/Patient/Booking/NewBooking.jsp")).thenReturn(mockedDispatcher);
		
		bookingForm.doPost(mockedRequest, mockedResponse);
		
		Mockito.verify(mockedDispatcher).forward(mockedRequest, mockedResponse);
		
	}
	
	/**
	 * Test method for {@link control.BookingForm#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Test
	final void testDoPostUserNotLogged() throws IOException, ServletException {
		Mockito.when(mockedSession.getAttribute("user")).thenReturn(null);
		
		bookingForm.doPost(mockedRequest, mockedResponse);
		
		Mockito.verify(mockedResponse).sendRedirect("Shared/SessionTimeOut.jsp");
		
	}

}
