package model.Bean;

import java.sql.Date;

/**
 * @author Tamburello Martina
 * This class represents a secretary object. 
 * It is used to define a particular type of user, the secretary.
 * 
 */
public class SecretaryBean extends UserBean {

	/**
	 * 
	 * Default empty constructor method
	 *
	 */
	public SecretaryBean() {
		super();
	}

	/**
	 * 
	 * Constructor method of the class SecretaryBean.
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
	public SecretaryBean(String fc, String un, String sn, Date bd, String bp, String r, String pwd, int pn, String e) {
		super(fc, un, sn, bd, bp, r, pwd, pn, e);
	}

	/**
	 * 
	 * Constructor method of the class SecretaryBean.
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
	public SecretaryBean(String fc, String un, String sn, Date bd, String bp, String r, int pn, String e) {
		super(fc, un, sn, bd, bp, r, pn, e);
	}

}
