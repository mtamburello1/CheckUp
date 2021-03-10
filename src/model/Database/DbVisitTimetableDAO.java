/**
 * 
 */
package model.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Bean.DoctorBean;
import model.Bean.VisitTimetableBean;
import model.Dao.VisitTimetableDAO;

/**
 * This class implements the VisitTimetableDAO interface, using the DataBase as persistence manager.
 * @author Tamburello Martina
 * @see VisitTimetableDAO
 */
public class DbVisitTimetableDAO implements VisitTimetableDAO {

	/** Query for new booking. */
	private static final String SelectDoctorAndTimetableSQL = "SELECT fiscal_code, user_name, surname, email, timetable_code, hour_visit, date_visit, duration, availability FROM user JOIN visitTimetable ON fiscal_code=doctor WHERE specialization = ? AND type_user='doctor'";
	/** Query to get a visit timetable. */
	private static final String ReturnVisitTimetableByKeySQL = "SELECT * FROM (visitTimetable NATURAL JOIN user) WHERE timetable_code = ?";
	/** Query for update visit timetable. */
	private static final String UpdateVisitTimetableSQL = "UPDATE visitTimetable SET availability=? WHERE timetable_code = ?";

	/**
	 * Returns a list of doctors for the specified specialization, with their relating visit timetable.
	 * @param specialization : specialization by which to seek doctors.
	 * @return a list of doctors with the specified specialization.
	 */
	@Override
	public ArrayList<DoctorBean> getDoctorsAndTimetables(String specialization){
		ArrayList <DoctorBean> doctors = new ArrayList<DoctorBean>();
		DoctorBean doctor;
		VisitTimetableBean visitTimetable;
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		if(specialization != null) {
			try {
				con = DbConnection.getConnection();       
				preparedStatement = con.prepareStatement(SelectDoctorAndTimetableSQL);
				preparedStatement.setString(1, specialization);
				preparedStatement.execute();
				result = preparedStatement.getResultSet();
				while (result.next()) {
					doctor = new DoctorBean(result.getString(1), result.getString(2), result.getString(3), result.getString(4), specialization);
					visitTimetable= new VisitTimetableBean(result.getString(5), doctor, result.getTime(6), result.getDate(7), result.getInt(8), result.getBoolean(9));
					int isIn = exists(doctors, doctor);
					if(isIn != -1) {
						(doctors.get(isIn)).addVisitTimetable(visitTimetable);
					}
					else {
						doctor.addVisitTimetable(visitTimetable);
						doctors.add(doctor);
					}
				}  
				con.close();
				return doctors;
			} 

			catch (SQLException e) {
				e.getMessage();        
			} 
		}
		return null;
	}

	private int exists(ArrayList<DoctorBean> doctors, DoctorBean doc) {
		int i = 0;
		while(i<doctors.size()) {
			if((doctors.get(i).getFiscal_code()).equalsIgnoreCase(doc.getFiscal_code())) {
				return i;
			}
			i++;
		}
		return -1;
	}

	/**
	 * Returns the visit timetable with the specified code.
	 * @param timetable_code : code of the visit timetable to seek.
	 * @return VisitTimetable the visit timetable with the specified code.
	 */
	@Override
	public VisitTimetableBean returnVisitTimetableByKey(String timetable_code) {

		VisitTimetableBean visitTimetable;
		DoctorBean doctor;
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		if(timetable_code != null) {
			try {
				con = DbConnection.getConnection(); 
				preparedStatement = con.prepareStatement(ReturnVisitTimetableByKeySQL);
				preparedStatement.setString(1, timetable_code);
				result = preparedStatement.executeQuery();


				if (result.first()) {
					doctor = new DoctorBean(result.getString("fiscal_code"), result.getString("user_name"), result.getString("surname"), result.getString("email"), result.getString("specialization"));
					visitTimetable = new VisitTimetableBean(result.getString("timetable_code"), doctor, result.getTime("hour_visit"), result.getDate("date_visit"), result.getInt("duration"), result.getBoolean("availability"));
					con.close();
					return visitTimetable;
				}
			} 

			catch (SQLException e) {

				e.printStackTrace();
			} 
		}
		return null;
	}

	/**
	 * Sets the availability of the visit timetable with the specified code.
	 * @param timetable_code : code of the visit timetable to update.
	 * @param availability : value on which to set the availability.
	 * @return true if it did the update, false otherwise.
	 */
	@Override
	public boolean updateVisitTimetable(String timetable_code, boolean availability) {

		Connection con = null;
		PreparedStatement preparedStatement = null;
		if (timetable_code != null){
			try {
				con = DbConnection.getConnection();
				preparedStatement = con.prepareStatement(UpdateVisitTimetableSQL);
				preparedStatement.setString(2, timetable_code);
				preparedStatement.setBoolean(1, availability);
				preparedStatement.execute();
				con.close();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * Calculates the code of the visit timetable for the specified booking.
	 * @param booking_code : booking code for which the respective visit timetable must be calculated.
	 * @return timetable_code the code of respective visit timetable.
	 */
	@Override
	public String calculateTimetable_code(String booking_code) {

		if(booking_code == null || booking_code.substring(booking_code.length()-32, booking_code.length()).contains("null")) {
			return null;
		}
		return (booking_code.substring(booking_code.length()-33, booking_code.length()));

	}

}
