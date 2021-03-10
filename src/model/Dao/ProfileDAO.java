/**
 * 
 */
package model.Dao;

import model.Bean.DoctorBean;
import model.Bean.PatientBean;
import model.Bean.UserBean;

/**
 * This interface provides the operations that can be performed by a Data Access Object (DAO) that accesses objects of type User and the objects they inherit from it.
 * @see UserBean
 * @see PatientBean
 * @see SecretaryBean
 * @see DoctorBean
 * @author Tamburello Martina
 *
 */
public interface ProfileDAO {

	/**
	 * Returns a patient with a specified fiscal code and password.
	 * @param fiscal_code : fiscal code of the patient to search for.
	 * @param pwd : password of the patient to search for.
	 * @return PatientBean : the patient sought or null if it doesn't exists.
	 */
	public PatientBean returnPatientByKey(String fiscal_code, String pwd);
	
	/**
	 * Returns a employee (SecretaryBean or DoctorBean) with a specified e-mail and password.
	 * @param email : email of the employee to search for.
	 * @param pwd : password of the employee to search for.
	 * @return UserBean : the employee sought or null if it doesn't exists.
	 */
	public UserBean returnEmployeeByKey(String email, String pwd);
	
	/**
	 * Returns a user with a specified fiscal code and password.
	 * @param fiscal_code : fiscal code of the user to search for.
	 * @param pwd : password of the user to search for.
	 * @return UserBean : the user sought or null if it doesn't exists.
	 */
	public UserBean returnUserByKey(String fiscal_code, String pwd);
	
	/**
	 * Changes a user's password.
	 * @param user : user with updated password.
	 * @param oldPwd : old user's password.
	 * @return true if the change has occurred, false otherwise.
	 */
	public boolean changePassword(UserBean user, String oldPwd);
}
