package model.Bean;

import java.sql.Date;
import java.util.ArrayList;

/**
 * @author Tamburello Martina
 * This class represents a patient object. 
 * It is used to define a particular type of user, the patient.
 * 
 */
public class PatientBean extends UserBean {

	/**
	 * 
	 * Default empty constructor method
	 *
	 */
	public PatientBean() {
		super();
		bookings = new ArrayList<BookingVisitBean>();
		medicalRecords = new ArrayList<MedicalRecordBean>();
	}

	/**
	 * 
	 * Constructor method of the class PatientBean.
	 *
	 * @param fc           	Fiscal code, String
	 * @param un        		User name, String
	 * @param sn   			Surname, String
	 * @param bd            	Birth date, Date
	 * @param bp         		Birth place, String
	 * @param r		        Place of residence, String
	 * @param pwd 			Password, String
	 * @param pn       		Phone number, int
	 * @param e 				Email, String
	 */
	public PatientBean(String fc, String un, String sn, Date bd, String bp, String r, String pwd, int pn, String e) {
		super(fc, un, sn, bd, bp, r, pwd, pn, e);
		bookings = new ArrayList<BookingVisitBean>();
		medicalRecords = new ArrayList<MedicalRecordBean>();
	}
	
	
	/**
	 * 
	 * Constructor method of the class PatientBean.
	 *
	 * @param fc           	Fiscal code, String
	 * @param un        		User name, String
	 * @param sn   			Surname, String
	 * @param bd            	Birth date, Date
	 * @param bp         		Birth place, String
	 * @param r		        Place of residence, String
	 * @param pwd 			Password, String
	 * @param pn       		Phone number, int
	 * @param e 				Email, String
	 */
	public PatientBean(String fc, String un, String sn, Date bd, String bp, String r, int pn, String e) {
		super(fc, un, sn, bd, bp, r, pn, e);
		bookings = new ArrayList<BookingVisitBean>();
		medicalRecords = new ArrayList<MedicalRecordBean>();
	}
	
	
	/**
	 * 
	 * Returns the patient booking list.
	 * @return bookings
	 */
	public ArrayList<BookingVisitBean> getBookings() {
		return bookings;
	}

	/**
	 * 
	 * Add a booking to the patient booking list.
	 * Return true if it added the item to the list, false otherwise.
	 * @param booking
	 * @return true or false
	 */
	public boolean addBooking(BookingVisitBean booking) {
		return bookings.add(booking);
	}

	/**
	 * 
	 * Returns the patient medical record list.
	 * @return medicalRecords
	 */
	public ArrayList<MedicalRecordBean> getMedicalRecords() {
		return medicalRecords;
	}

	/**
	 * 
	 * Add a medical record to the patient medical record list.
	 * Return true if it added the item to the list, false otherwise.
	 * @param medicalRecord
	 * @return true or false
	 */
	public boolean addMedicalRecord(MedicalRecordBean medicalRecord) {
		return medicalRecords.add(medicalRecord);
	}

	private ArrayList<BookingVisitBean> bookings; 
	private ArrayList<MedicalRecordBean> medicalRecords;

}
