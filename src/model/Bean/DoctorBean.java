package model.Bean;

import java.sql.Date;
import java.util.ArrayList;

/**
 * @author Tamburello Martina
 * This class represents a doctor object. 
 * It is used to define a particular type of user, the doctor.
 * 
 */
public class DoctorBean extends UserBean{

	/**
	 * 
	 * Default empty constructor method
	 *
	 */
	public DoctorBean() {
		super();
		this.visitTimetables = new ArrayList<VisitTimetableBean>();
		this.medicalRecords = new ArrayList<MedicalRecordBean>();
	}
	
	/**
	 * 
	 * Constructor method of the class DoctorBean.
	 *
	 * @param fc           	Fiscal code, String
	 * @param un        	User name, String
	 * @param sn   			Surname, String
	 * @param bd            Birth date, Date
	 * @param bp         	Birth place, String
	 * @param r		        Place of residence, String
	 * @param pwd 			Password, String
	 * @param pn       		Phone number, int
	 * @param e 			Email, String
	 * @param s 			Specialization, String
	 */
	
	public DoctorBean(String fc, String un, String sn, Date bd, String bp, String r, String pwd, int pn, String e, String s) {
		super(fc, un, sn, bd, bp, r, pwd, pn, e);
		this.setSpecialization(s);
		this.visitTimetables = new ArrayList<VisitTimetableBean>();
		this.medicalRecords = new ArrayList<MedicalRecordBean>();
	}
	
	/**
	 * 
	 * Constructor method of the class DoctorBean.
	 *
	 * @param fc           	Fiscal code, String
	 * @param un        	User name, String
	 * @param sn   			Surname, String
	 * @param e 			Email, String
	 * @param s 			Specialization, String
	 */
	public DoctorBean(String fc, String un, String sn, String e, String s) {
		this.setFiscal_code(fc);
		this.setUser_name(un);
		this.setSurname(sn);
		this.setEmail(e);
		this.setSpecialization(s);
		this.visitTimetables = new ArrayList<VisitTimetableBean>();
		this.medicalRecords = new ArrayList<MedicalRecordBean>();
	}	
	
	/**
	 * 
	 * Returns the specialization of the doctor.
	 * @return specialization
	 */
	public String getSpecialization() {
		return specialization;
	}

	/**
	 * 
	 * Sets the value of the doctor's specialization.
	 * @param specialization
	 */
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	/**
	 * 
	 * Returns the visit timetable list of the doctor.
	 * @return medicalRecords
	 */
	public ArrayList<VisitTimetableBean> getVisitTimetable() {
		return this.visitTimetables;
	}
	
	/**
	 * 
	 * Add a visit timetable to the doctor's visit timetable list.
	 * Return true if it added the item to the list, false otherwise.
	 * @param visitTimetable
	 * @return true or false
	 */
	public boolean addVisitTimetable(VisitTimetableBean visitTimetable) {
		return this.visitTimetables.add(visitTimetable);
	}

	/**
	 * 
	 * Returns the doctor's medical record list.
	 * @return medicalRecords
	 */
	public ArrayList<MedicalRecordBean> getMedicalRecords() {
		return medicalRecords;
	}
	
	/**
	 * 
	 * Add a medical record to the doctor's medical record list.
	 * Return true if it added the item to the list, false otherwise.
	 * @param medicalRecord
	 * @return true or false
	 */
	public boolean addMedicalRecord(MedicalRecordBean medicalRecord) {
		return medicalRecords.add(medicalRecord);
	}

	private String specialization;
	private ArrayList<VisitTimetableBean> visitTimetables;
	private ArrayList<MedicalRecordBean> medicalRecords;

}
