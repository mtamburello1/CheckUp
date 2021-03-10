package model.Bean;
import java.sql.Date;

/**
 * @author Tamburello Martina
 * This class represents an user object. 
 * It is used to define an user for the system.
 *
 */
public class UserBean {

	/**
	 * 
	 * Default empty constructor method
	 *
	 */
	public UserBean() {
		
	}

	
	/**
	   * 
	   * Constructor method of the class UserBean.
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
	public UserBean(String fc, String un, String sn, Date bd, String bp, String r, String pwd, int pn, String e) {
		this.fiscal_code = fc;
		this.user_name = un;
		this.surname = sn;
		this.birth_date = bd;
		this.birth_place = bp;
		this.residence = r;
		this.user_password = pwd; 
		this.phone_number = pn;
		this.email = e;
	}
	
	
	/**
	   * 
	   * Constructor method of the class UserBean.
	   *
	   * @param fc           	Fiscal code, String
	   * @param un        		User name, String
	   * @param sn   			Surname, String
	   * @param bd            	Birth date, Date
	   * @param bp         		Birth place, String
	   * @param r		        Place of residence, String
	   * @param pn       		Phone number, int
	   * @param e 				Email, String
	   */
	public UserBean(String fc, String un, String sn, Date bd, String bp, String r, int pn, String e) {
		this.fiscal_code = fc;
		this.user_name = un;
		this.surname = sn;
		this.birth_date = bd;
		this.birth_place = bp;
		this.residence = r; 
		this.phone_number = pn;
		this.email = e;
	}
	

	/**
	   * 
	   * Returns the value of the identification code relating to the user.
	   * @return fiscal_code
	   */
	public String getFiscal_code() {
		return fiscal_code;
	}
	
	/**
	   * 
	   * Sets the value of the identification code relating to the user.
	   * @param fiscal_code
	   */
	public void setFiscal_code(String fiscal_code) {
		this.fiscal_code = fiscal_code;
	}
	
	/**
	   * 
	   * Returns the value of the user's name.
	   * @return user_name
	   */
	public String getUser_name() {
		return user_name;
	}
	
	/**
	   * 
	   * Sets the value of the user's name.
	   * @param user_name
	   */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	/**
	   * 
	   * Returns the value of the user's surname.
	   * @return user_surname
	   */
	public String getSurname() {
		return surname;
	}
	
	/**
	   * 
	   * Sets the value of the user's surname.
	   * @param user_surname
	   */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/**
	   * 
	   * Returns the value of the user's date of birth.
	   * @return birth_date
	   */
	public Date getBirth_date() {
		return birth_date;
	}
	
	/**
	   * 
	   * Sets the value of the user's date of birth.
	   * @param birth_date
	   */
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	
	/**
	   * 
	   * Returns the value of the user's place of birth.
	   * @return birth_place
	   */
	public String getBirth_place() {
		return birth_place;
	}
	
	/**
	   * 
	   * Sets the value of the user's place of birth.
	   * @param birth_place
	   */
	public void setBirth_place(String birth_place) {
		this.birth_place = birth_place;
	}
	
	/**
	   * 
	   * Returns the value of the user's residence.
	   * @return residence
	   */
	public String getResidence() {
		return residence;
	}
	
	/**
	   * 
	   * Sets the value of the user's residence.
	   * @param residence
	   */
	public void setResidence(String residence) {
		this.residence = residence;
	}
	
	/**
	   * 
	   * Returns the value of the user's password.
	   * @return user_password
	   */
	public String getUser_password() {
		return user_password;
	}
	
	/**
	   * 
	   * Sets the value of the user's password.
	   * @param user_password
	   */
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	
	/**
	   * 
	   * Returns the value of the user's phone number.
	   * @return phone_number
	   */
	public int getPhone_number() {
		return phone_number;
	}
	
	/**
	   * 
	   * Sets the value of the user's phone number.
	   * @param phone_number the phone number of the user
	   */
	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}
	
	/**
	   * 
	   * Returns the value of the user's email.
	   * @return email
	   */
	public String getEmail() {
		return email;
	}
	
	/**
	   * 
	   * Sets the value of the user's email.
	   * @param email
	   */
	public void setEmail(String email) {
		this.email = email;
	}
	

	private String fiscal_code;
	private String user_name;
	private String surname;
	private Date birth_date;
	private String birth_place;
	private String residence;
	private String user_password;
	private int phone_number;
	private String email;

}
