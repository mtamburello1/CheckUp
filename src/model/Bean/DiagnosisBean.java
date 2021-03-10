package model.Bean;

import java.sql.Date;

/**
 * @author Tamburello Martina
 * This class represents a report of a diagnosis object. 
 * It is used to define a report of a patient's diagnosis.
 *
 */
public class DiagnosisBean extends ReportBean {

	/**
	 * 
	 * Default empty constructor method
	 *
	 */
	public DiagnosisBean() {
		super();
	}
	
	/**
	   * 
	   * Constructor method of the class DiagnosisBean.
	   *
	   * @param rc 				Report code, String
	   * @param mrc          	Medical record code, String
	   * @param id        		Insertion date, java.sql.Date
	   * @param d   			Doctor, DoctorBean
	   * @param p            	Patient, PatientBean
	   * @param dd		        Diagnosis description, String
	   * @param rfv      		Reason for the visit, String
	   */
	public DiagnosisBean(String rc, String mrc, Date id, DoctorBean d, PatientBean p,String dd, String rfv) {
		super(rc, mrc, id, d, p);
		this.diagnosis_description = dd;
		this.reason_for_the_visit = rfv;
	}

	/**
	   * 
	   * Returns a diagnosis's description.
	   * @return diagnosis_description
	   */
	public String getDiagnosis_description() {
		return diagnosis_description;
	}

	/**
	   * 
	   * Sets the value of a diagnosis's description.
	   * @param diagnosis_description
	   */
	public void setDiagnosis_description(String diagnosis_description) {
		this.diagnosis_description = diagnosis_description;
	}

	/**
	   * 
	   * Returns the reason why the patient visited.
	   * @return reason_for_the_visit
	   */
	public String getReason_for_the_visit() {
		return reason_for_the_visit;
	}

	/**
	   * 
	   * Sets the reason why the patient visited.
	   * @param reason_for_the_visit
	   */
	public void setReason_for_the_visit(String reason_for_the_visit) {
		this.reason_for_the_visit = reason_for_the_visit;
	}

	private String diagnosis_description;
	private String reason_for_the_visit;
}
