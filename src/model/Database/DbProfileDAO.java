package model.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Bean.DoctorBean;
import model.Bean.PatientBean;
import model.Bean.SecretaryBean;
import model.Bean.UserBean;
import model.Dao.ProfileDAO;

/**
 * This class implements the ProfileDAO interface, using the DataBase as persistence manager.
 * @author Tamburello Martina
 * @see ProfileDAO
 */
public class DbProfileDAO implements ProfileDAO{
	/** Query for patient's login. */
	private static final String ReturnPatientByKeySQL = "SELECT * FROM user WHERE fiscal_code = ? AND user_password= ? AND type_user= 'patient'";
	/** Query for employee's login. */
	private static final String ReturnEmployeeByKeySQL = "SELECT * FROM user WHERE email = ? AND user_password= ? AND (type_user= 'secretary' OR type_user='doctor')";
	/** Query for query to fetch a user. */
	private static final String ReturnUserByKeySQL = "SELECT * FROM user WHERE fiscal_code = ? AND user_password= ?";
	/** Query to change password. */
	private static final String ChangePwdSQL = "UPDATE user SET user_password= ? WHERE fiscal_code= ? AND user_password=?";

	
	/**
	 * Returns a patient with a specified fiscal code and password.
	 * @param fc : fiscal code of the patient to search for.
	 * @param pwd : password of the patient to search for.
	 * @return PatientBean : the patient sought or null if it doesn't exists.
	 */
	@Override
	public PatientBean returnPatientByKey(String fc, String pwd) {

		PatientBean patient;
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		if(fc != null && pwd != null) {
			try {
				con = DbConnection.getConnection(); 
				preparedStatement = con.prepareStatement(ReturnPatientByKeySQL);
				preparedStatement.setString(1, fc);
				preparedStatement.setString(2, pwd);
				result = preparedStatement.executeQuery();

				if (result.first()) {
					patient = new PatientBean (result.getString("fiscal_code"), result.getString("user_name"), result.getString("surname"), result.getDate("birth_date"), result.getString("birth_place"), result.getString("residence"), result.getString("user_password"), result.getInt("phone_number"), result.getString("email"));
					con.close();
					if(patient.getUser_password().equals(pwd)) {
						return patient;
					}
					else {
						return null;
					}
				}
			} 
			catch (SQLException e) {

				e.printStackTrace();
			} 
		}
		return null;
	}

	
	/**
	 * Returns a employee (SecretaryBean or DoctorBean) with a specified e-mail and password.
	 * @param email : e-mail of the employee to search for.
	 * @param pwd : password of the employee to search for.
	 * @return UserBean : the employee sought or null if it doesn't exists.
	 */
	@Override
	public UserBean returnEmployeeByKey(String email, String pwd) {

		UserBean employee;
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		if(email != null && pwd != null) {
			try {
				con = DbConnection.getConnection(); 
				preparedStatement = con.prepareStatement(ReturnEmployeeByKeySQL);
				preparedStatement.setString(1, email);
				preparedStatement.setString(2, pwd);
				result = preparedStatement.executeQuery();

				if (result.first()) {
					if(result.getString("type_user").equalsIgnoreCase("doctor")){
						employee = new DoctorBean(result.getString("fiscal_code"), result.getString("user_name"), result.getString("surname"), result.getDate("birth_date"), result.getString("birth_place"), result.getString("residence"), result.getString("user_password"), result.getInt("phone_number"), result.getString("email"), result.getString("specialization"));
					}
					else if (result.getString("type_user").equalsIgnoreCase("secretary")){
						employee = new SecretaryBean(result.getString("fiscal_code"), result.getString("user_name"), result.getString("surname"), result.getDate("birth_date"), result.getString("birth_place"), result.getString("residence"), result.getString("user_password"), result.getInt("phone_number"), result.getString("email"));
					}
					else {
						employee = null;
					}
					con.close();
					return employee;
				}
			} 
			catch (SQLException e) {

				e.printStackTrace();
			} 
		}
		return null;
	}

	
	/**
	 * Returns a user with a specified fiscal code and password.
	 * @param fiscal_code : fiscal code of the user to search for.
	 * @param pwd : password of the user to search for.
	 * @return UserBean : the user sought or null if it doesn't exists.
	 */
	@Override
	public UserBean returnUserByKey(String fiscal_code, String pwd) {

		UserBean user;
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		if(fiscal_code != null && pwd != null) {
			try {
				con = DbConnection.getConnection(); 
				preparedStatement = con.prepareStatement(ReturnUserByKeySQL);
				preparedStatement.setString(1, fiscal_code);
				preparedStatement.setString(2, pwd);
				result = preparedStatement.executeQuery();


				if (result.first()) {

					user = new UserBean(result.getString("fiscal_code"), result.getString("user_name"), result.getString("surname"), result.getDate("birth_date"), result.getString("birth_place"), result.getString("residence"), result.getString("user_password"), result.getInt("phone_number"), result.getString("email"));

					con.close();
					return user;
				}
			} 

			catch (SQLException e) {

				e.printStackTrace();
			} 
		}
		return null;
	}

	/**
	 * Changes a user's password.
	 * @param user : user with updated password.
	 * @param oldPwd : old user's password.
	 * @return true if the change has occurred, false otherwise.
	 */
	@Override
	public boolean changePassword(UserBean user, String oldPwd) {

		Connection con = null;
		PreparedStatement preparedStatement = null;
		if(user != null && oldPwd != null) {
			try {
				con = DbConnection.getConnection(); 
				preparedStatement = con.prepareStatement(ChangePwdSQL);
				preparedStatement.setString(1, user.getUser_password());
				preparedStatement.setString(2, user.getFiscal_code());
				preparedStatement.setString(3, oldPwd);
				preparedStatement.execute();
				con.close();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		return false;
	}

}
