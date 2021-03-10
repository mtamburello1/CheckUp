/**
 * 
 */
package control.Booking;


import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;

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

import model.Bean.DoctorBean;
import model.Bean.PatientBean;
import model.Bean.VisitTimetableBean;

/**
 * @author Tamburello Martina
 *
 */
class BookingHourTest {

	private BookingHour bookingHour;
	private HttpServletRequest mockedRequest;
	private HttpServletResponse mockedResponse;
	private HttpSession mockedSession;
	private PatientBean patient;
	private ArrayList<VisitTimetableBean> vt;
	private PrintWriter mockedOut;
	
	/**
	 * @throws java.lang.Exception
	 */
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		bookingHour = new BookingHour();
		mockedRequest = Mockito.mock(HttpServletRequest.class);
		mockedResponse = Mockito.mock(HttpServletResponse.class);
		mockedSession = Mockito.mock(HttpSession.class);
		Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
		mockedOut = Mockito.mock(PrintWriter.class);
		patient = Mockito.mock(PatientBean.class);
		patient.setFiscal_code("RSSMRO88N75U789K");
		DoctorBean doctor = new DoctorBean("VRDLGI88O09P789F", "Luigi", "Verdi", "luigi@checkUp.it", "oculistica");
		VisitTimetableBean v = new VisitTimetableBean(doctor.getFiscal_code()+"/"+"2021-01-19"+"/"+"14:30" ,doctor, new Time(14,30,00), new Date(2021-1900, 01-01, 19), 30, true);
		vt = new ArrayList<VisitTimetableBean>();
		vt.add(v);
	}
	

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link control.BookingHour#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Test
	final void testDoPostSuccessfull() throws ServletException, IOException {
		Mockito.when(mockedSession.getAttribute("user")).thenReturn(patient);
		Mockito.when(mockedRequest.getParameter("booking_date")).thenReturn("gen 19, 2021");
		Mockito.when(mockedSession.getAttribute("visitTimetables")).thenReturn(vt);
		Mockito.when(mockedResponse.getWriter()).thenReturn(mockedOut);
		
		bookingHour.doPost(mockedRequest, mockedResponse);
		
		Mockito.verify(mockedOut).write("[{\"hour\":\"02:30:00 PM\",\"timetable_code\":\"VRDLGI88O09P789F/2021-01-19/14:30\"}]");

	}

	
	/**
	 * Test method for {@link control.BookingHour#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Test
	final void testDoPostUserNotLogged() throws ServletException, IOException {
		Mockito.when(mockedSession.getAttribute("user")).thenReturn(null);
		
		bookingHour.doPost(mockedRequest, mockedResponse);
		
		Mockito.verify(mockedResponse).sendRedirect("Shared/SessionTimeOut.jsp");
	}

}
