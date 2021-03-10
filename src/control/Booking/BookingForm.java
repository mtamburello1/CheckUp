package control.Booking;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Database.DbUserDAO;
import model.Dao.UserDAO;

/**
 * Servlet implementation class NewBookingForm. 
 * It has the purpose of showing the booking form and allowing the patient to select a type of visit from the database.
 */
@WebServlet("/BookingForm")
public class BookingForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookingForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") == null) {
			response.sendRedirect("Shared/SessionTimeOut.jsp");
		}
		else {
			UserDAO userDAO = new DbUserDAO();
			ArrayList<String> specializations = new ArrayList<String>();
			specializations = userDAO.getSpecializations();
			request.setAttribute("specializations", specializations);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Patient/Booking/NewBooking.jsp");
			dispatcher.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
