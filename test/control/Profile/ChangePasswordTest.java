/**
 * 
 */
package control.Profile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import model.Bean.UserBean;
import model.Dao.ProfileDAO;
import model.Database.DbProfileDAO;

/**
 * @author Tamburello Martina
 *
 */
class ChangePasswordTest {

	private ChangePassword changePwd;
	private HttpServletRequest mockedRequest;
	private HttpServletResponse mockedResponse;
	private HttpSession mockedSession;
	private UserBean user;
	private PrintWriter mockedOut;
	private static String newPwd;
	private String oldPwd;

	/**
	 * @throws java.lang.Exception
	 */
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		newPwd = "qwerty";
		oldPwd = "martina";
		changePwd = new ChangePassword();
		mockedRequest = Mockito.mock(HttpServletRequest.class);
		mockedResponse = Mockito.mock(HttpServletResponse.class);
		mockedSession = Mockito.mock(HttpSession.class);
		Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
		mockedOut = Mockito.mock(PrintWriter.class);
		user = new UserBean("RSSMRS54U78Y654R", "Maria Rosaria", "Rossi", new Date(1954-1900,5-1,24), "Salerno", "Salerno", "16b02287e8a9f1d5bb5a4afacaf6ac7124c62846bad58d8f48acc27598a2cb7a", 435464744, "MariaRosaria@live.it");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		@SuppressWarnings("deprecation")
		UserBean u= new UserBean("RSSMRS54U78Y654R", "Maria Rosaria", "Rossi", new Date(1954-1900,5-1,24), "Salerno", "Salerno", "16b02287e8a9f1d5bb5a4afacaf6ac7124c62846bad58d8f48acc27598a2cb7a", 435464744, "MariaRosaria@live.it");
		ProfileDAO pDAO = new DbProfileDAO();
		pDAO.changePassword(u, "65e84be33532fb784c48129675f9eff3a682b27168c0ea744b2cf58ee02337c5");
	}

	/**
	 * Test method for {@link control.ChangePassword#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Test
	final void testDoPostSuccessfull() throws ServletException, IOException {
		
		Mockito.when(mockedSession.getAttribute("user")).thenReturn(user);
		Mockito.when(mockedRequest.getParameter("password")).thenReturn(oldPwd);
		Mockito.when(mockedRequest.getParameter("newPassword")).thenReturn(newPwd);
		Mockito.when(mockedRequest.getParameter("passwordConfirm")).thenReturn(newPwd);
		Mockito.when(mockedResponse.getWriter()).thenReturn(mockedOut);
		
		changePwd.doPost(mockedRequest, mockedResponse);
	
		Mockito.verify(mockedOut).println("1");

	}

	/**
	 * Test method for {@link control.ChangePassword#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws IOException 
	 * @throws ServletException 
	*/
	@Test
	final void testDoPostWrongPassword() throws ServletException, IOException {
	
		String wrongPwd = "000009";
		
		Mockito.when(mockedSession.getAttribute("user")).thenReturn(user);
		Mockito.when(mockedResponse.getWriter()).thenReturn(mockedOut);
		Mockito.when(mockedRequest.getParameter("password")).thenReturn(wrongPwd);
		Mockito.when(mockedRequest.getParameter("newPassword")).thenReturn(newPwd);
		Mockito.when(mockedRequest.getParameter("passwordConfirm")).thenReturn(newPwd);
		
		changePwd.doPost(mockedRequest, mockedResponse);
			
		Mockito.verify(mockedOut).println("-1");

	}
	
	/**
	 * Test method for {@link control.ChangePassword#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Test
	final void testDoPostMissingValues() throws ServletException, IOException {
		
		Mockito.when(mockedSession.getAttribute("user")).thenReturn(user);
		Mockito.when(mockedResponse.getWriter()).thenReturn(mockedOut);
		Mockito.when(mockedRequest.getParameter("password")).thenReturn(oldPwd);
		Mockito.when(mockedRequest.getParameter("newPassword")).thenReturn(null);
		Mockito.when(mockedRequest.getParameter("passwordConfirm")).thenReturn(null);
		
		changePwd.doPost(mockedRequest, mockedResponse);
			
		Mockito.verify(mockedOut).println("-1");

	}
	
	/**
	 * Test method for {@link control.ChangePassword#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Test
	final void testDoPostPasswordNotMatch() throws ServletException, IOException {
		
		Mockito.when(mockedSession.getAttribute("user")).thenReturn(user);
		Mockito.when(mockedResponse.getWriter()).thenReturn(mockedOut);
		Mockito.when(mockedRequest.getParameter("password")).thenReturn(oldPwd);
		Mockito.when(mockedRequest.getParameter("newPassword")).thenReturn(newPwd);
		Mockito.when(mockedRequest.getParameter("passwordConfirm")).thenReturn(oldPwd);
		
		changePwd.doPost(mockedRequest, mockedResponse);
			
		Mockito.verify(mockedOut).println("-2");

	}
	
	/**
	 * Test method for {@link control.ChangePassword#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Test
	final void testDoPostSamePassword() throws ServletException, IOException {
		
		Mockito.when(mockedSession.getAttribute("user")).thenReturn(user);
		Mockito.when(mockedResponse.getWriter()).thenReturn(mockedOut);
		Mockito.when(mockedRequest.getParameter("password")).thenReturn(oldPwd);
		Mockito.when(mockedRequest.getParameter("newPassword")).thenReturn(oldPwd);
		Mockito.when(mockedRequest.getParameter("passwordConfirm")).thenReturn(oldPwd);
		
		changePwd.doPost(mockedRequest, mockedResponse);
			
		Mockito.verify(mockedOut).println("-3");

	}
	
	/**
	 * Test method for {@link control.ChangePassword#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Test
	final void testDoPostUserNotLogged() throws ServletException, IOException {
		Mockito.when(mockedSession.getAttribute("user")).thenReturn(null);
		
		changePwd.doPost(mockedRequest, mockedResponse);
		
		Mockito.verify(mockedResponse).sendRedirect("Shared/SessionTimeOut.jsp");
	}

}
