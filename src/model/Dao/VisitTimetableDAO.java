/**
 * 
 */
package model.Dao;

import java.util.ArrayList;

import model.Bean.DoctorBean;
import model.Bean.VisitTimetableBean;

/**
 * @author Tamburello Martina
 *
 */
public interface VisitTimetableDAO {

	/**
	 * Returns a list of doctors for the specified specialization, with their relating visit timetable.
	 * @param specialization : specialization by which to seek doctors.
	 * @return a list of doctors with the specified specialization.
	 */
	public ArrayList<DoctorBean> getDoctorsAndTimetables(String specialization);
	
	/**
	 * Returns the visit timetable with the specified code.
	 * @param timetable_code : code of the visit timetable to seek.
	 * @return VisitTimetable the visit timetable with the specified code.
	 */
	public VisitTimetableBean returnVisitTimetableByKey(String timetable_code);
	
	/**
	 * Sets the availability of the visit timetable with the specified code.
	 * @param timetable_code : code of the visit timetable to update.
	 * @param availability : value on which to set the availability.
	 * @return true if it did the update, false otherwise.
	 */
	public boolean updateVisitTimetable(String timetable_code, boolean availability);

	/**
	 * Calculates the code of the visit timetable for the specified booking.
	 * @param booking_code : booking code for which the respective visit timetable must be calculated.
	 * @return timetable_code the code of respective visit timetable.
	 */
	public String calculateTimetable_code(String booking_code);
}
