/**
 * 
 */
package model.Dao;

import java.util.ArrayList;

/**
 * This interface provides the operations that can be performed by a Data Access Object (DAO) that accesses and manages objects of type User and the objects they inherit from it.
 * @see UserBean
 * @see PatientBean
 * @see SecretaryBean
 * @see DoctorBean
 * @author Tamburello Martina
 *
 */
public interface UserDAO {

	/**
	 * @return the specializations of all doctors in the repository.
	 */
	public ArrayList<String> getSpecializations();
}
