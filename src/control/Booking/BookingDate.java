package control.Booking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Bean.DoctorBean;
import model.Bean.VisitTimetableBean;
/**
 * Servlet implementation class BookingDate.
 * It is intended to take a doctor's availability dates from a list of doctors.
 */
@WebServlet("/BookingDate")
public class BookingDate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookingDate() {
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") == null) {
			response.sendRedirect("Shared/SessionTimeOut.jsp");
		}
		else {
			ArrayList<DoctorBean> doctors = new ArrayList<DoctorBean>();
			PrintWriter out = response.getWriter();
			doctors = (ArrayList<DoctorBean>) request.getSession().getAttribute("doctors");
			String doctor_fiscal_code = request.getParameter("fiscal_code");
			ArrayList<Date> date = new ArrayList<Date>();
			ArrayList <VisitTimetableBean> vt = new ArrayList<VisitTimetableBean>();
			for(DoctorBean doc : doctors) {
				if(doc.getFiscal_code().equalsIgnoreCase(doctor_fiscal_code)) {
					vt = doc.getVisitTimetable();
					for(VisitTimetableBean v : vt) {
						if(!date.contains(v.getDate_visit()) && v.isAvailability()){
							date.add(v.getDate_visit());
						}
					}
				}
			}

			request.getSession().setAttribute("visitTimetables",vt);
			String json = new Gson().toJson(date);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.write(json);
		}
	}

}
