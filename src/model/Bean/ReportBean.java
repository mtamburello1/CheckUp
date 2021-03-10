package model.Bean;

import java.sql.Date;

/**
 * @author Tamburello Martina
 * This class represents a report object. 
 * It is used to define the results contained in the patient's medical record.
 *
 */
public class ReportBean {

	/**
	 * 
	 * Default empty constructor method
	 *
	 */
	public ReportBean() {}
	
	/**
	   * 
	   * Constructor method of the class ReportBean.
	   *
	   * @param rc 				Report code, String
	   * @param mrc          	Medical record code, String
	   * @param id        		Insertion date, Date
	   * @param d   			Doctor, DoctorBean
	   * @param p            	Patient, PatientBean
	   */
	public ReportBean(String rc, String mrc, Date id, DoctorBean d, PatientBean p) {
		this.report_code = rc;
		this.medical_record_code=mrc;
		this.insertion_date=id;
		this.doctor=d;
		this.patient=p;
	}
	
	/**
	 * Returns the identification code relating to the report.
	 * @return report_code
	 */
	public String getReport_code() {
		return report_code;
	}

	/**
	 * Sets the identification code relating to the report.
	 * @param report_code
	 */
	public void setReport_code(String report_code) {
		this.report_code = report_code;
	}
	
	/**
	 * 
	 * Returns the value of the identification code relating to the medical record to which the report belongs.
	 * @return medical_record_code
	 */
	public String getMedical_record_code() {
		return medical_record_code;
	}
	
	/**
	 * 
	 * Sets the value of the identification code relating to the medical report to which the report belongs.
	 * @param medical_record_code the code of the medical record that contains the report
	 */
	public void setMedical_record_code(String medical_record_code) {
		this.medical_record_code = medical_record_code;
	}
	
	/**
	  * 
	  * Returns date of insertion of the report.
	  * @return insertion_date
	  */
	public Date getInsertion_date() {
		return insertion_date;
	}
	
	/**
	  * 
	  * Sets the date of insertion of the report.
	  * @param insertion_date
	  */
	public void setInsertion_date(Date insertion_date) {
		this.insertion_date = insertion_date;
	}
	
	/**
	  * 
	  * Returns the doctor to which the report refers.
	  * @return doctor
	  */
	public DoctorBean getDoctor() {
		return doctor;
	}
	
	/**
	  * 
	  * Sets the doctor to which the report refers.
	  * @param doctor
	  */
	public void setDoctor(DoctorBean d) {
		this.doctor = d;
	}
	
	/**
	  * 
	  * Returns the patient to which the report refers.
	  * @return patient
	  */
	public PatientBean getPatient() {
		return patient;
	}
	
	/**
	  * 
	  * Sets the patient to which the report refers.
	  * @param patient
	  */
	public void setPatient(PatientBean p) {
		this.patient = p;
	}
	
	private String medical_record_code;
	private String report_code;
	private Date insertion_date;
	private DoctorBean doctor;
	private PatientBean patient;
}
