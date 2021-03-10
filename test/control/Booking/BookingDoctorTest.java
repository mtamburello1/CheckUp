/**
 * 
 */
package control.Booking;
import java.io.IOException;
import java.io.PrintWriter;
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
class BookingDoctorTest {

	private HttpServletRequest mockedRequest;
	private HttpServletResponse mockedResponse;
	private PrintWriter mockedOut;
	private HttpSession mockedSession;
	private BookingDoctor bookingDoctor;
	private PatientBean patient;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		mockedRequest = Mockito.mock(HttpServletRequest.class);
		mockedResponse = Mockito.mock(HttpServletResponse.class);
		mockedSession = Mockito.mock(HttpSession.class);
		Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
		mockedOut = Mockito.mock(PrintWriter.class);
		bookingDoctor = new BookingDoctor();
		patient = Mockito.mock(PatientBean.class);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link control.BookingDoctor#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Test
	final void testDoPostSuccessfull() throws IOException, ServletException {
		
		Mockito.when(mockedResponse.getWriter()).thenReturn(mockedOut);
		Mockito.when(mockedSession.getAttribute("user")).thenReturn(patient);
		Mockito.when(mockedRequest.getParameter("specialization")).thenReturn("allergologia");
		
		bookingDoctor.doPost(mockedRequest, mockedResponse);
		
		Mockito.verify(mockedOut).print("[{\"name\":\"De Lucia Carmine\",\"fiscal_code\":\"DLCCRM76U56G678I\"}]");
	}
	
	/**
	 * Test method for {@link control.BookingDoctor#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Test
	final void testDoPostUserNotLogged() throws IOException, ServletException {
		Mockito.when(mockedRequest.getSession().getAttribute("user")).thenReturn(null);
		
		bookingDoctor.doPost(mockedRequest, mockedResponse);
		
		Mockito.verify(mockedResponse).sendRedirect("Shared/SessionTimeOut.jsp");
		
	}

}
