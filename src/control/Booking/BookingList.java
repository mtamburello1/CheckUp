package control.Booking;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Database.DbBookingDAO;
import model.Bean.PatientBean;
import model.Dao.BookingDAO;
import model.Bean.BookingVisitBean;
/**
 * Servlet implementation class BookingList. 
 * It has the purpose to allow the patient to view the list of the booking he has made. 
 */
@WebServlet("/BookingList")
public class BookingList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookingList() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PatientBean patient = (PatientBean) request.getSession().getAttribute("user");

		if(patient == null) {
			response.sendRedirect("Shared/SessionTimeOut.jsp");
		}
		else {
			BookingDAO bookingDAO = new DbBookingDAO();
			ArrayList<BookingVisitBean> bookings = new ArrayList<BookingVisitBean>();
			bookings = bookingDAO.getBookingList(patient);
			request.setAttribute("bookingList", bookings);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Patient/Booking/BookingList.jsp");
			dispatcher.forward(request, response);
		}
	}

}
