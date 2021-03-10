/**
 * 
 */
package control.Booking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import model.Bean.DoctorBean;
import model.Bean.PatientBean;
import model.Bean.VisitTimetableBean;

/**
 * @author Tamburello Martina
 *
 */
class BookingDateTest {

	private BookingDate bookingDate;
	private ArrayList<DoctorBean> doctors;
	private PrintWriter mockedOut;
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
		mockedRequest = Mockito.mock(HttpServletRequest.class);
		mockedResponse = Mockito.mock(HttpServletResponse.class);
		mockedSession = Mockito.mock(HttpSession.class);
		Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
		doctors = new ArrayList<DoctorBean>();
		DoctorBean doctor = new DoctorBean("VRDLGI88O09P789F", "Luigi", "Verdi", "luigi@checkUp.it", "oculistica");
		VisitTimetableBean v = new VisitTimetableBean(doctor.getFiscal_code()+"/"+"2021-01-13"+"/"+"10:30" ,doctor, new Time(10,30,00), new Date(2021-1900, 01-01, 13), 30, true);
		doctor.addVisitTimetable(v);
		doctors.add(doctor);
		mockedOut = Mockito.mock(PrintWriter.class);
		Mockito.when(mockedResponse.getWriter()).thenReturn(mockedOut);
		bookingDate = new BookingDate();
		patient = Mockito.mock(PatientBean.class);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link control.BookingDate#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Test
	final void testDoPostSuccessfull() throws ServletException, IOException {
		
		Mockito.when(mockedSession.getAttribute("user")).thenReturn(patient);
		Mockito.when(mockedRequest.getParameter("fiscal_code")).thenReturn("VRDLGI88O09P789F");
		Mockito.when(mockedRequest.getSession().getAttribute("doctors")).thenReturn(doctors);
		
		bookingDate.doPost(mockedRequest, mockedResponse);
		
		Mockito.verify(mockedOut).write("[\"gen 13, 2021\"]");
		
	}
	
	/**
	 * Test method for {@link control.BookingDate#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Test
	final void testDoPostUserNotLogged() throws IOException, ServletException {
		
		Mockito.when(mockedRequest.getSession().getAttribute("user")).thenReturn(null);
		
		bookingDate.doPost(mockedRequest, mockedResponse);
		
		Mockito.verify(mockedResponse).sendRedirect("Shared/SessionTimeOut.jsp");
	}

}
