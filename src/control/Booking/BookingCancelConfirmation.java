package control.Booking;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bean.PatientBean;
import model.Dao.BookingDAO;
import model.Dao.VisitTimetableDAO;
import model.Database.DbBookingDAO;
import model.Database.DbVisitTimetableDAO;

/**
 * Servlet implementation class BookingCancellationConfirmation.
 * It has the purpose of permanently deleting a booking and make the relevant timetable available again.
 */
@WebServlet("/BookingCancelConfirmation")
public class BookingCancelConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookingCancelConfirmation() {
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
		if (patient == null) {
			response.sendRedirect("Shared/SessionTimeOut.jsp");
		}
		else {
			String booking_code = request.getParameter("booking_code");
			if(booking_code == null) {
				response.sendRedirect("/CheckUp/Patient/Booking/Denied.jsp");
			}
			else {
				BookingDAO bookingDAO = new DbBookingDAO();
				boolean deleted = bookingDAO.deleteBooking(booking_code);
				if(deleted) {
					VisitTimetableDAO vt = new DbVisitTimetableDAO();
					String timetable_code = vt.calculateTimetable_code(booking_code);
					vt.updateVisitTimetable(timetable_code, true);
					response.sendRedirect("/CheckUp/Patient/Booking/BookingDeleted.jsp");
				}

				else {
					response.sendRedirect("/CheckUp/Patient/Booking/Denied.jsp");
				}
			}
		}
	}

}
