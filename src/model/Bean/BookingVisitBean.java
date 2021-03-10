package model.Bean;

import java.sql.Time;
import java.sql.Date;

/**
 * @author Tamburello Martina
 * This class represents a booking object. 
 *
 */
public class BookingVisitBean {
	
	/**
	 * 
	 * Default empty constructor method
	 *
	 */
	public BookingVisitBean() {
		this.doctor = new DoctorBean();
		this.patient = new PatientBean();
	}
	
	/**
	   * 
	   * Constructor method of the class BookingVisitBean.
	   *
	   * @param p          	Patient, PatientBean
	   * @param d        	Doctor, DoctorBean
	   * @param bd   		Booking day, Date
	   * @param bh          Booking hour, Time
	   * @param bt	        Booking type, String
	   * @param co      	Carried out, Boolean
	   */
	public BookingVisitBean(PatientBean p, DoctorBean d, Date bd, Time bh, String bt, Boolean co) {
		this.patient = new PatientBean();
		this.patient = p;
		this.doctor = new DoctorBean();
		this.doctor = d;
		this.booking_day = bd;
		this.booking_hour = bh;
		this.booking_type = bt;
		this.carried_out = co;
		this.booking_code = this.calculateBookingVisit_code();
	}

	/**
	   * 
	   * Constructor method of the class BookingVisitBean.
	   *
	   * @param bc          Booking code, String
	   * @param p          	Patient, PatientBean
	   * @param d        	Doctor, DoctorBean
	   * @param bd   		Booking day, Date
	   * @param bh          Booking hour, Time
	   * @param bt	        Booking type, String
	   * @param co      	Carried out, Boolean
	   */
	public BookingVisitBean(String bc, PatientBean p, DoctorBean d, Date bd, Time bh, String bt, Boolean co) {
		this.booking_code = bc;
		this.patient = new PatientBean();
		this.patient = p;
		this.doctor = new DoctorBean();
		this.doctor = d;
		this.booking_day = bd;
		this.booking_hour = bh;
		this.booking_type = bt;
		this.carried_out = co;
	}

	/**
	  * 
	  * Returns the identification code relating to the booking visit.
	  * @return booking_code
	  */
	public String getBooking_code() {
		return booking_code;
	}
	/**
	  * 
	  * Sets the value of the identification code relating to the booking visit.
	  * @param booking_code
	  */
	public void setBooking_code(String booking_code) {
		this.booking_code = booking_code;
	}
	
	/**
	  * 
	  * Returns the doctor which has been selected for the booking.
	  * @return doctor;
	  */
	public DoctorBean getDoctor() {
		return doctor;
	}
	
	/**
	  * 
	  * Sets the doctor which has been selected for the booking.
	  * @param doctor;
	  */
	public void setDoctor(DoctorBean doctor) {
		this.doctor = doctor;
	}
	
	/**
	  * 
	  * Returns the patient to which the booking refers.
	  * @return patient;
	  */
	public PatientBean getPatient() {
		return patient;
	}
	
	/**
	  * 
	  * Sets the patient to which the booking refers.
	  * @param patient;
	  */
	public void setPatient(PatientBean patient) {
		this.patient = patient;
	}
	
	/**
	  * 
	  * Returns the booking date.
	  * @return booking_day;
	  */
	public Date getBooking_day() {
		return booking_day;
	}
	
	/**
	  * 
	  * Sets the booking date.
	  * @param booking_day;
	  */
	public void setBooking_day(Date booking_day) {
		this.booking_day = booking_day;
	}
	
	/**
	  * 
	  * Returns the booking hour.
	  * @return booking_hour;
	  */
	public Time getBooking_hour() {
		return booking_hour;
	}
	
	/**
	  * 
	  * Sets the booking hour.
	  * @param booking_hour;
	  */
	public void setBooking_hour(Time booking_hour) {
		this.booking_hour = booking_hour;
	}
	
	/**
	  * 
	  * Returns the booking type.
	  * @return booking_type;
	  */
	public String getBooking_type() {
		return booking_type;
	}
	
	/**
	  * 
	  * Sets the booking type.
	  * @param booking_type;
	  */
	public void setBooking_type(String booking_type) {
		this.booking_type = booking_type;
	}
	
	/**
	  * 
	  * Returns true if the booking is already carried out, false otherwise.
	  * @return carried_out;
	  */
	public boolean isCarried_out() {
		return carried_out;
	}
	
	/**
	  * 
	  * Sets the parameter carried_out to true if the booking is already carried out, false otherwise.
	  * @param carried_out;
	  */
	public void setCarried_out(boolean carried_out) {
		this.carried_out = carried_out;
	}

	/**
	  * 
	  * 	Calculate the booking code.
	  * 
	  **/
	private String calculateBookingVisit_code() {
		
		if(patient == null || doctor == null || booking_type == null || booking_day == null || booking_hour == null) {
			throw new CodeNullException();
		}
		
		return (patient.getFiscal_code()+"/"+booking_type+"/"+doctor.getFiscal_code()+"/"+booking_day+"/"+ booking_hour.toString().substring(0,5));
	}

	
	private String booking_code;
	private DoctorBean doctor;
	private PatientBean patient;
	private Date booking_day;
	private Time booking_hour;
	private String booking_type;
	private boolean carried_out;
}
