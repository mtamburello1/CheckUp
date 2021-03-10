package model.Bean;

import java.sql.Date;

/**
 * @author Tamburello Martina
 * This class represents a report of an exam result object. 
 * It is used to define a report of a patient's exam.
 *
 */
public class ExamResultBean extends ReportBean{
	

	/**
	 * 
	 * Default empty constructor method
	 *
	 */
	public ExamResultBean() {
		super();
	}
	
	/**
	 * 
	 * Constructor method of the class ExamResultBean.
	 *
	 * @param rc 			Report code, String
	 * @param mrc          	Medical record code, String
	 * @param id        	Insertion date, Date
	 * @param d   			Doctor, DoctorBean
	 * @param p            	Patient, PatientBean
	 * @param ec		    Exam code, String
	 * @param n	 			Note, String
	 * @param rf       		Path of report file, String
	 * @param r 			Revised, Boolean
	 */
	public ExamResultBean(String rc, String mrc, Date id, DoctorBean d, PatientBean p, String ec, String n, String rf, Boolean r) {
		super(rc, mrc, id, d, p);
		this.note = n;
		this.report_file = rf;
		this.setRevised(r);
	}
	

	/**
	 * 
	 * Returns true if the report is in the overhauled state, false otherwise.
	 * @return revised
	 */
	public boolean isRevised() {
		return revised;
	}

	/**
	 * 
	 * Sets the value 'revised' to true if the report has been reviewed, false otherwise.
	 * @param revised
	 */
	public void setRevised(boolean revised) {
		this.revised = revised;
	}

	/**
	 * 
	 * Returns the value of the note entered by the patient in the relative report.
	 * @return note
	 */	
	public String getNote() {
		return note;
	}

	/**
	 * 
	 * Sets the value of the note in the relative report.
	 * @param note
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * 
	 * Returns the report's path.
	 * @return report_file
	 */
	public String getReport_file() {
		return report_file;
	}

	/**
	 * 
	 * Sets the value of the report's path.
	 * @param report_file
	 */
	public void setReport_file(String report_file) {
		this.report_file = report_file;
	}
	

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}



	private String type;
	private boolean revised;
	private String note;
	private String report_file;
}
