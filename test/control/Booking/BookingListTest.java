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
class BookingListTest {

	private BookingList bookingList;
	private HttpServletRequest mockedRequest;
	private HttpServletResponse mockedResponse;
	private HttpSession mockedSession;
	private ServletContext mockedServletContext;
	private RequestDispatcher mockedDispatcher;
	private PatientBean patient;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		bookingList = new BookingList();
		mockedRequest = Mockito.mock(HttpServletRequest.class);
		mockedResponse = Mockito.mock(HttpServletResponse.class);
		mockedSession = Mockito.mock(HttpSession.class);
		mockedServletContext = Mockito.mock(ServletContext.class);
		mockedDispatcher = Mockito.mock(RequestDispatcher.class);
		Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
		patient = Mockito.mock(PatientBean.class);
		patient.setFiscal_code("RSSMRO88N75U789K");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link control.BookingList#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Test
	final void testDoPostSuccessfull() throws ServletException, IOException {
		Mockito.when(mockedSession.getAttribute("user")).thenReturn(patient);
		Mockito.when(mockedRequest.getServletContext()).thenReturn(mockedServletContext);
		Mockito.when(mockedServletContext.getRequestDispatcher("/Patient/Booking/BookingList.jsp")).thenReturn(mockedDispatcher);
		
		bookingList.doPost(mockedRequest, mockedResponse);
		
		Mockito.verify(mockedDispatcher).forward(mockedRequest, mockedResponse);

	}
	
	/**
	 * Test method for {@link control.BookingList#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Test
	final void testDoPostUserNotLogged() throws ServletException, IOException {
		Mockito.when(mockedSession.getAttribute("user")).thenReturn(null);
		
		bookingList.doPost(mockedRequest, mockedResponse);
		
		Mockito.verify(mockedResponse).sendRedirect("Shared/SessionTimeOut.jsp");
	}

}
