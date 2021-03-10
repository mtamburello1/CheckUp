package control.Booking;

import java.io.IOException;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.util.StringConverter;
import model.Database.DbBookingDAO;
import model.Database.DbVisitTimetableDAO;
import model.Bean.BookingVisitBean;
import model.Bean.DoctorBean;
import model.Bean.PatientBean;
import model.Dao.BookingDAO;
import model.Dao.VisitTimetableDAO;

/**
 * Servlet implementation class NewBooking.
 * It has the purpose to collect data for the creation of a new booking and, once the booking has been created, to make the relevant timetable unavailable.
 */
@WebServlet("/NewBooking")
public class NewBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewBooking() {
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

		PatientBean patient = (PatientBean) request.getSession().getAttribute("user");

		if(patient == null) {
			response.sendRedirect("Shared/SessionTimeOut.jsp");
		}
		else {
			String specialization = request.getParameter("specialization");
			String doctor_fiscal_code = request.getParameter("fiscal_code");
			String hour = request.getParameter("hours");
			String date = request.getParameter("date");
			if(hour == null || date == null || doctor_fiscal_code == null || specialization == null) {
				response.sendRedirect("BookingForm");
			}

			else {
				java.sql.Date booking_date = StringConverter.stringToDate(date);
				if(booking_date == null) {
					response.sendRedirect("BookingForm");
				}
				else {
					Time booking_hour = java.sql.Time.valueOf(hour);
					DoctorBean doctor = new DoctorBean();
					doctor.setFiscal_code(doctor_fiscal_code);
					Boolean isCarriedOut = false;
					BookingVisitBean booking = new BookingVisitBean(patient, doctor, booking_date, booking_hour, specialization, isCarriedOut); 
					
					BookingDAO bookingDAO = new DbBookingDAO();
					boolean created = bookingDAO.insertBooking(booking);
					if(created) {
						VisitTimetableDAO vt = new DbVisitTimetableDAO();
						String timetable_code = vt.calculateTimetable_code(booking.getBooking_code());
						vt.updateVisitTimetable(timetable_code, false);
						response.sendRedirect("/CheckUp/Patient/Booking/BookingConfirmed.jsp");
					}
					else {
						response.sendRedirect("/CheckUp/Patient/Booking/Denied.jsp");
					}
				}
			}
		}
	}

}
