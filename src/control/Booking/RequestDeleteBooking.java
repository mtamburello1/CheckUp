package control.Booking;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.util.StringConverter;
import model.Bean.BookingVisitBean;
import model.Bean.DoctorBean;
import model.Bean.PatientBean;

/**
 * Servlet implementation class RequestDeleteBooking
 * It has the purpose of creating a request page for confirming the cancellation of a booking.
 */
@WebServlet("/RequestDeleteBooking")
public class RequestDeleteBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestDeleteBooking() {
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
			Boolean isCarried_out;
			String carriedOut = request.getParameter("carried_out");
			if(carriedOut == null || carriedOut.equalsIgnoreCase("True")) {
				response.sendRedirect("/CheckUp/Patient/Booking/Denied.jsp");
			}
			else {
				isCarried_out = false;
				String doctor_fiscal_code = request.getParameter("doctor_fiscal_code");
				DoctorBean doctor = new DoctorBean();
				doctor.setFiscal_code(doctor_fiscal_code);
				doctor.setUser_name(request.getParameter("doctor_surname"));
				doctor.setSurname("doctor_user_name");
				Date booking_date = StringConverter.dateStringToDate(request.getParameter("booking_date"));
				if(booking_date == null) {
					response.sendRedirect("/CheckUp/Patient/Booking/Denied.jsp");
				}
				else {
					Time booking_hour = java.sql.Time.valueOf(request.getParameter("booking_hour"));
					String booking_type = request.getParameter("booking_type");

					BookingVisitBean booking = new BookingVisitBean(patient, doctor, booking_date, booking_hour, booking_type, isCarried_out);
					request.setAttribute("bookingToDelete", booking);
					RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/CheckUp/Patient/Booking/BookingCancelConfirmation.jsp");
					dispatcher.forward(request, response);
				}
			}
		}
	}

}
