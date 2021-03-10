/**
 * 
 */
package control.Profile;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import model.Bean.UserBean;

/**
 * @author Tamburello Martina
 *
 */
class LoginEmployeeTest {

	private LoginEmployee loginEmployee;
	private HttpServletRequest mockedRequest;
	private HttpServletResponse mockedResponse;
	private ServletContext mockedServletContext;
	private HttpSession mockedSession;
	private UserBean employee;
	private PrintWriter mockedOut;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		loginEmployee = new LoginEmployee();
		mockedRequest = Mockito.mock(HttpServletRequest.class);
		mockedResponse = Mockito.mock(HttpServletResponse.class);
		mockedSession = Mockito.mock(HttpSession.class);
		mockedServletContext = Mockito.mock(ServletContext.class);
		mockedOut = Mockito.mock(PrintWriter.class);
		employee = Mockito.mock(UserBean.class);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link control.LoginEmployee#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws javax.servlet.ServletException
	 * @throws java.io.IOException
	 */ 
	@Test
	final void testDoPostSuccessful() throws ServletException, IOException{
		
		Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
		Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
		Mockito.when(mockedRequest.getParameter("email")).thenReturn("luigi@checkUp.it");
		Mockito.when(mockedRequest.getParameter("user_password")).thenReturn("martina");
		Mockito.when(mockedResponse.getWriter()).thenReturn(mockedOut);
		
		loginEmployee.doPost(mockedRequest, mockedResponse);

		Mockito.verify(mockedOut).println("1");
		Mockito.verify(mockedSession).setAttribute(Mockito.eq("user"), Mockito.any(UserBean.class));
	}
	
	
	/**
	 * Test method for {@link control.LoginEmployee#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws javax.servlet.ServletException
	 * @throws java.io.IOException
	 */ 
	@Test
	final void testDoPostFailure() throws ServletException, IOException{

		Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
		Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
		Mockito.when(mockedRequest.getParameter("fiscal_code")).thenReturn("dcdscsdc");
		Mockito.when(mockedRequest.getParameter("user_password")).thenReturn("aaaaaaaa");
		Mockito.when(mockedResponse.getWriter()).thenReturn(mockedOut);

		loginEmployee.doPost(mockedRequest, mockedResponse);

		Mockito.verify(mockedOut).println("0");
	}
	
	/**
	 * Test method for {@link control.LoginEmployee#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws javax.servlet.ServletException
	 * @throws java.io.IOException
	 */ 
	@Test
	final void testDoPostUserAlreadyLogged() throws ServletException, IOException{

		Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
		Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
		Mockito.when(mockedSession.getAttribute("user")).thenReturn(employee);

		loginEmployee.doPost(mockedRequest, mockedResponse);

		Mockito.verify(mockedResponse).sendRedirect("index.jsp");
	}

	
}
