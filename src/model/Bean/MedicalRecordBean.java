package model.Bean;

import java.util.ArrayList;

/**
 * @author Tamburello Martina
 * This class represents a medical record object. 
 * It is used to define the medical record of a patient.
 * 
 */
public class MedicalRecordBean {

	/**
	 * 
	 * Default empty constructor method
	 *
	 */
	public MedicalRecordBean() {
		this.reports=new ArrayList<ReportBean>();
	}
	
	/**
	 * 
	 * Add a report to the patient medical record.
	 * @param report
	 */
	public boolean addReport(ReportBean report) {
		return this.reports.add(report);
	}

	/**
	 * 
	 * Returns the report list.
	 * @return reports
	 */
	public ArrayList<ReportBean> getReports() {
		return this.reports;
	}

	/**
	 * @return the medical_record_code
	 */
	public String getMedical_record_code() {
		return medical_record_code;
	}

	/**
	 * @param medical_record_code the medical_record_code to set
	 */
	public void setMedical_record_code(String medical_record_code) {
		this.medical_record_code = medical_record_code;
	}

	


	/**
	 * @return the doctor
	 */
	public DoctorBean getDoctor() {
		return doctor;
	}

	/**
	 * @param doctor the doctor to set
	 */
	public void setDoctor(DoctorBean doctor) {
		this.doctor = doctor;
	}

	/**
	 * @return the patient
	 */
	public PatientBean getPatient() {
		return patient;
	}

	/**
	 * @param patient the patient to set
	 */
	public void setPatient(PatientBean patient) {
		this.patient = patient;
	}




	private DoctorBean doctor;
	private PatientBean patient;
	private ArrayList<ReportBean> reports;
	private String medical_record_code;
}
