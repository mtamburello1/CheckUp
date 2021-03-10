package model.Bean;

import java.sql.Time;
import java.sql.Date;

/**
 * @author Tamburello Martina
 * This class represents a visiting timetable object. 
 * It is used to define the times available for patient bookings.
 *
 */
public class VisitTimetableBean {

	/**
	 * 
	 * Default empty constructor method
	 *
	 */
	public VisitTimetableBean() {}
	
	
	/**
	   * 
	   * Constructor method of the class VisitTimetableBean.
	   *
	   * @param tc           	Timetable code, String
	   * @param doc        		Doctor, DoctorBean
	   * @param hv   			Hour visit, Time
	   * @param dv            	Date visit, Date
	   * @param d         		Duration, int
	   * @param a      			Availability, Boolean
	   */
	public VisitTimetableBean(String tc, DoctorBean doc, Time hv, Date dv, int d, boolean a) {
		this.setTimetable_code(tc);					
		this.setDoctor(doc); 								
		this.setHour_visit(hv);					
		this.setDate_visit(dv);			
		this.setDuration(d);						
		this.setAvailability(a);
	}
	
	
	/**
	   * 
	   * Constructor method of the class VisitTimetableBean.
	   *
	   * @param doc        		Doctor fiscal code, String
	   * @param hv   			Hour visit, Time
	   * @param dv            	Date visit, Date
	   * @param d         		Duration, int
	   * @param a      			Availability, Boolean
	   */
	public VisitTimetableBean(DoctorBean doc, Time hv, Date dv, int d, Boolean a) {
		this.doctor = new DoctorBean();
		this.doctor = doc; 								
		this.setHour_visit(hv);					
		this.setDate_visit(dv);			
		this.setDuration(d);
		this.setAvailability(a);
	}
	
	/**
	   * 
	   * Returns the value of the identification code relating to the visiting time.
	   * @return timetable_code code relating to the visit timetable
	   */
	public String getTimetable_code() {
		return timetable_code;
	}

	/**
	   * 
	   * Sets the value of the identification code relating to the visiting time.
	   * @param timetable_code code relating to the visit timetable
	   */
	public void setTimetable_code(String timetable_code) {
		this.timetable_code = timetable_code;
	}

	/**
	   * 
	   * Returns the doctor relating to the visiting time.
	   * @return doctor doctor relating to the visit timetable
	   */
	public DoctorBean getDoctor() {
		return doctor;
	}

	/**
	   * 
	   * Sets the doctor relating to the visiting time.
	   * @param doctor doctor relating to the visit timetable
	   */
	public void setDoctor(DoctorBean doctor) {
		this.doctor = doctor;
	}

	/**
	   * 
	   * Returns visiting hour relating to the visiting timetable.
	   * @return hour_visit hour of the visit timetable
	   */
	public Time getHour_visit() {
		return hour_visit;
	}

	/**
	   * 
	   * Sets hour of visit relating to the visiting timetable.
	   * @param hour_visit hour of the visit timetable
	   */
	public void setHour_visit(Time hour_visit) {
		this.hour_visit = hour_visit;
	}

	/**
	   * 
	   * Returns visiting date relating to the visiting timetable.
	   * @return date_visit date of the visit timetable
	   */
	public Date getDate_visit() {
		return date_visit;
	}

	/**
	   * 
	   * Sets date of visit relating to the visiting timetable.
	   * @param date_visit date of the visit timetable
	   */
	public void setDate_visit(Date date_visit) {
		this.date_visit = date_visit;
	}

	/**
	   * 
	   * Returns the value of the duration of the visit relating to the visiting time.
	   * @return duration duration of the visit for the timetable
	   */
	public int getDuration() {
		return duration;
	}

	/**
	   * 
	   * Sets the value of the duration of the visit relating to the visiting time.
	   * @param duration duration of the visit for the timetable
	   */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	   * 
	   * Returns true if the visit timetable is availability, false if it is already been busy.
	   * @return hour_visit hour_visit of visit timetable
	   */
	public boolean isAvailability() {
		return availability;
	}

	/**
	   * 
	   * Sets the availability of the visit timetable.
	   * @param availability availability of the visit timetable
	   */
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	
	private String timetable_code;
	private DoctorBean doctor;
	private Time hour_visit;
	private Date date_visit;
	private int duration;
	private boolean availability;
}
