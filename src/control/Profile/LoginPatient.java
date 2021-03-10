package control.Profile;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.util.PasswordEncrypter;
import model.Database.DbProfileDAO;
import model.Bean.UserBean;
import model.Dao.ProfileDAO;

/**
 * Servlet implementation class LoginPatient.
 * It has the purpose to allow a patient to login.
 */
@WebServlet("/LoginPatient")
public class LoginPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginPatient() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") != null) {
			response.sendRedirect("index.jsp");
		}
		else {
			String fiscal_code=request.getParameter("fiscal_code");
			String user_password= request.getParameter("user_password");
			PrintWriter out = response.getWriter();
			ProfileDAO profileDAO=new DbProfileDAO();
			UserBean patient= profileDAO.returnPatientByKey(fiscal_code, PasswordEncrypter.crypt(user_password));

			if(patient != null) {
				HttpSession session= request.getSession();
				session.setAttribute( "user" , patient);
				session.setMaxInactiveInterval(-1);
				out.println("1");
			}

			else {
				out.println("0"); 
			}
		}
	}

}
