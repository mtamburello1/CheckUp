package control.Profile;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.util.PasswordEncrypter;
import model.Database.DbProfileDAO;
import model.Bean.UserBean;
import model.Dao.ProfileDAO;

/**
 * Servlet implementation class ChangePassword.
 * It has the purpose of changing a user's password.
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePassword() {
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

		UserBean user = (UserBean) request.getSession().getAttribute("user");

		if (user == null) {
			response.sendRedirect("Shared/SessionTimeOut.jsp");
		}
		else {
			String password = request.getParameter("password");
			String newPassword = request.getParameter("newPassword");
			String passwordConfirm = request.getParameter("passwordConfirm");
			PrintWriter out = response.getWriter();

			ProfileDAO profileDAO = new DbProfileDAO();
			if(newPassword == null || newPassword.equals("") || newPassword.equals(" ")) {
				out.println("-1");
			}
			else if(!newPassword.equals("") && newPassword != null && !newPassword.equals(" ")) {
				String pwd = PasswordEncrypter.crypt(password);
				String newPwd = PasswordEncrypter.crypt(newPassword);
				String pwdConfirm = PasswordEncrypter.crypt(passwordConfirm);
				String actualUserPwd = user.getUser_password();
				if(actualUserPwd.equals(pwd) && !actualUserPwd.equals(newPwd) && newPwd.equals(pwdConfirm)) {
					user.setUser_password(newPwd);
					boolean updated = profileDAO.changePassword(user, actualUserPwd);
					if(updated) {
						request.getSession().setAttribute("user", user);
						out.println("1");
					}
					else 
						out.println("-1");	

				}

				else if(!(actualUserPwd.equals(pwd))){
					out.println("-1");
				}

				else if(!(newPwd.equals(pwdConfirm))) {
					out.println("-2");
				}
				else if(actualUserPwd.equals(pwd)) {
					out.println("-3");
				}
			}
		}
	}

}
