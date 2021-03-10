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
import model.Bean.DoctorBean;
import model.Bean.SecretaryBean;
import model.Bean.UserBean;
import model.Dao.ProfileDAO;

/**
 * Servlet implementation class LoginEmployee.
 * It has the purpose to allow an employee to login.
 */
@WebServlet("/LoginEmployee")
public class LoginEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") != null) {
			response.sendRedirect("index.jsp");
		}
		else {
			String email=request.getParameter("email");
			String user_password= request.getParameter("user_password");
			PrintWriter out=response.getWriter();
			ProfileDAO profileDAO=new DbProfileDAO();
			UserBean employee= profileDAO.returnEmployeeByKey(email, PasswordEncrypter.crypt(user_password));

			if(employee != null) {
				HttpSession session= request.getSession();
				session.setAttribute( "user" , employee);

				if(employee instanceof DoctorBean) {
					out.println("1");
				}
				else if(employee instanceof SecretaryBean) {
					out.println("2");
				}
			}

			else {
				out.println("0"); 
			}
		}
	}

}
