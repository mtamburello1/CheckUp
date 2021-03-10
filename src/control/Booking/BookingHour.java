package control.Booking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Bean.VisitTimetableBean;

/**
 * Servlet implementation class BookingHour. 
 * Given a list of dates and hours, it's meant to select the times available for a certain date.
 */
@WebServlet("/BookingHour")
public class BookingHour extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookingHour() {
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
			PrintWriter out = response.getWriter();
			String booking_date = request.getParameter("booking_date");
			ArrayList<JsonObject> hours = new ArrayList<JsonObject>();
			ArrayList <VisitTimetableBean> vt = new ArrayList<VisitTimetableBean>();
			DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy"); 
			vt = (ArrayList<VisitTimetableBean>)request.getSession().getAttribute("visitTimetables");
			if(vt!=null) {
				for(VisitTimetableBean v : vt) {
					String strDate = dateFormat.format((v.getDate_visit()));
					if(strDate.equals(booking_date)) {
						JsonObject h = new JsonObject(v.getHour_visit(), v.getTimetable_code());
						hours.add(h);
					}			
				}
			}

			String json = new Gson().toJson(hours);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.write(json);
		}
	}

	private class JsonObject {

		private JsonObject(Time h, String tc) {
			this.hour = h;
			this.timetable_code = tc;
		}

		@SuppressWarnings("unused")
		private Time hour;
		@SuppressWarnings("unused")
		private String timetable_code;
	}

}
