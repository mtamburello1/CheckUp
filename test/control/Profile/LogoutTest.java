/**
 * 
 */
package control.Profile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * @author Tamburello Martina
 *
 */
class LogoutTest {

	private Logout logout;
	private HttpServletRequest mockedRequest;
	private HttpServletResponse mockedResponse;
	private HttpSession mockedSession;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		logout = new Logout();
		mockedRequest = Mockito.mock(HttpServletRequest.class);
		mockedResponse = Mockito.mock(HttpServletResponse.class);
		mockedSession = Mockito.mock(HttpSession.class);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link control.Logout#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@Test
	void testDoGet() throws IOException, ServletException {
		
		Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
		
		logout.doGet(mockedRequest, mockedResponse);
		
		Mockito.verify(mockedSession).invalidate();
		Mockito.verify(mockedResponse).sendRedirect("index.jsp");
	}

}
