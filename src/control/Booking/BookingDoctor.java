package control.Booking;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Database.DbVisitTimetableDAO;
import model.Bean.DoctorBean;
import model.Dao.VisitTimetableDAO;


/**
 * Servlet implementation class BookingDoctor. 
 * It aims to show all doctors with the specialization entered by the patient.
 */
@WebServlet("/BookingDoctor")
public class BookingDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookingDoctor() {
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
		if (request.getSession().getAttribute("user") == null) {
			response.sendRedirect("Shared/SessionTimeOut.jsp");
		}
		else {
			VisitTimetableDAO visitTimetableDAO = new DbVisitTimetableDAO();
			PrintWriter out = response.getWriter();
			String specialization = request.getParameter("specialization");
			ArrayList<DoctorBean> doctors = new ArrayList<DoctorBean>();
			doctors = visitTimetableDAO.getDoctorsAndTimetables(specialization);
			ArrayList<JsonObject> doctorsNames= new ArrayList<JsonObject>();
			for(DoctorBean doc : doctors) {
				JsonObject dn = new JsonObject(doc.getSurname() + " " + doc.getUser_name(), doc.getFiscal_code());
				doctorsNames.add(dn);
			}
			String json = new Gson().toJson(doctorsNames);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			request.getSession().setAttribute("doctors", doctors);
			out.print(json);
		}
	}

	private class JsonObject {

		private JsonObject(String n, String fc) {
			this.name = n;
			this.fiscal_code = fc;
		}

		
		@SuppressWarnings("unused")
		private String name;
		@SuppressWarnings("unused")
		private String fiscal_code;
	}


}
