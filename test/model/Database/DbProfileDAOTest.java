/**
 * 
 */
package model.Database;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Bean.DoctorBean;
import model.Bean.PatientBean;
import model.Bean.SecretaryBean;
import model.Bean.UserBean;
import model.Dao.ProfileDAO;

/**
 * @author Tamburello Martina
 *
 */
class DbProfileDAOTest {


	private ProfileDAO profileDAO;
	private String fiscal_code;
	private String email_secretary;
	private static String user_password;
	private static String user_password2;
	private PatientBean patientExpected;
	private PatientBean patientActual;
	private DoctorBean doctorExpected;
	private DoctorBean doctorActual;
	private SecretaryBean secretaryExpected;
	private SecretaryBean secretaryActual;
	private UserBean userExpected;
	private UserBean userActual;
	private UserBean user;

	/**
	 * @throws java.lang.Exception
	 */
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		profileDAO = new DbProfileDAO();
		fiscal_code = "RSSMRO88N75U789K";
		email_secretary = "pasquale@checkUp.it";
		user_password = "16b02287e8a9f1d5bb5a4afacaf6ac7124c62846bad58d8f48acc27598a2cb7a";
		user_password2 = "25c73520e69f4bf229811e8e46ffe7d80471544b9bee15ed25044b86be4115ad";
		patientExpected = new PatientBean(fiscal_code, "Mario", "Rossi", new Date(1998-1900,11-1,24), "Napoli", "Napoli", user_password, 435464744, "mario@hotmail.it");
		patientActual = new PatientBean();
		doctorExpected = new DoctorBean("SRRGPP76U65C365T", "Giuseppe", "Sorrentino", new Date(1976-1900, 2-1, 10), "Milano", "Salerno", user_password,  435464744, "giuseppe@checkUp.it", "urologia");
		secretaryExpected = new SecretaryBean("NRPSQL70Y67U987O", "Pasquale", "Neri", new Date(1970-1900, 12-1, 9), "Salerno", "Salerno", user_password,  12345678, "pasquale@checkUp.it");
		userActual = new UserBean();
		userExpected = new UserBean("VRDLGI88O09P789F", "Verdi", "Luigi", new Date(1976-1900,3-1,3), "Salerno", "Salerno", user_password2, 435464744, "carmine@checkUp.it");
		user = new UserBean();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		@SuppressWarnings("deprecation")
		UserBean u = new UserBean("DLCCRM76U56G678I", "Carmine", "De Lucia", new Date(1976-1900,3-1,3), "Salerno", "Salerno", user_password, 435464744, "carmine@checkUp.it");
		ProfileDAO pDAO = new DbProfileDAO();
		pDAO.changePassword(u, user_password2);
	}

	/**
	 * Test method for {@link model.DbProfileDAO#ReturnPatientByKey(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testReturnPatientByKey() {
		patientActual = (PatientBean)profileDAO.returnPatientByKey(fiscal_code, user_password);
		assertEquals(patientExpected.getFiscal_code(), patientActual.getFiscal_code());
		assertEquals(patientExpected.getUser_name(), patientActual.getUser_name());
		assertEquals(patientExpected.getSurname(), patientActual.getSurname());
		assertEquals(patientExpected.getBirth_date(), patientActual.getBirth_date());
		assertEquals(patientExpected.getBirth_place(), patientActual.getBirth_place());
		assertEquals(patientExpected.getResidence(), patientActual.getResidence());
		assertEquals(patientExpected.getUser_password(), patientActual.getUser_password());
		assertEquals(patientExpected.getPhone_number(), patientActual.getPhone_number());
		assertEquals(patientExpected.getEmail(), patientActual.getEmail());
	}


	/**
	 * Test method for {@link model.DbProfileDAO#ReturnPatientByKey(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testReturnPatientByKey_notExists() {
		patientActual = (PatientBean)profileDAO.returnPatientByKey("AAAAAAA", "BBbbbbB");
		assertNull(patientActual);
	}


	/**
	 * Test method for {@link model.DbProfileDAO#ReturnEmployeeByKey(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testReturnEmployeeByKey_employeeIsDoctor() {
		doctorActual = (DoctorBean)profileDAO.returnEmployeeByKey(doctorExpected.getEmail(), user_password);
		assertTrue(doctorActual instanceof DoctorBean);
		assertEquals(doctorExpected.getFiscal_code(), doctorActual.getFiscal_code());
		assertEquals(doctorExpected.getUser_name(), doctorActual.getUser_name());
		assertEquals(doctorExpected.getSurname(), doctorActual.getSurname());
		assertEquals(doctorExpected.getBirth_date(), doctorActual.getBirth_date());
		assertEquals(doctorExpected.getBirth_place(), doctorActual.getBirth_place());
		assertEquals(doctorExpected.getResidence(), doctorActual.getResidence());
		assertEquals(doctorExpected.getUser_password(), doctorActual.getUser_password());
		assertEquals(doctorExpected.getPhone_number(), doctorActual.getPhone_number());
		assertEquals(doctorExpected.getEmail(), doctorActual.getEmail());
		assertEquals(doctorExpected.getSpecialization(), doctorActual.getSpecialization());
	}


	/**
	 * Test method for {@link model.DbProfileDAO#ReturnEmployeeByKey(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testReturnEmployeeByKey_employeeIsSecretary() {
		secretaryActual = (SecretaryBean)profileDAO.returnEmployeeByKey(email_secretary, user_password);
		assertTrue(secretaryActual instanceof SecretaryBean);
		assertEquals(secretaryExpected.getFiscal_code(), secretaryActual.getFiscal_code());
		assertEquals(secretaryExpected.getUser_name(), secretaryActual.getUser_name());
		assertEquals(secretaryExpected.getSurname(), secretaryActual.getSurname());
		assertEquals(secretaryExpected.getBirth_date(), secretaryActual.getBirth_date());
		assertEquals(secretaryExpected.getBirth_place(), secretaryActual.getBirth_place());
		assertEquals(secretaryExpected.getResidence(), secretaryActual.getResidence());
		assertEquals(secretaryExpected.getUser_password(), secretaryActual.getUser_password());
		assertEquals(secretaryExpected.getPhone_number(), secretaryActual.getPhone_number());
		assertEquals(secretaryExpected.getEmail(), secretaryActual.getEmail());
	}


	/**
	 * Test method for {@link model.DbProfileDAO#ReturnEmployeeByKey(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testReturnEmployeeByKey_notExists() {
		secretaryActual = (SecretaryBean)profileDAO.returnEmployeeByKey("AAAAA", "BBBBB");
		assertNull(secretaryActual);	
	}

	/**
	 * Test method for {@link model.DbProfileDAO#ReturnUserByKey(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testReturnUserByKey() {
		user = profileDAO.returnUserByKey(fiscal_code, user_password);
		assertEquals(user.getFiscal_code(), fiscal_code);
		assertEquals(user.getUser_password(), user_password);
	}

	/**
	 * Test method for {@link model.DbProfileDAO#ReturnUserByKey(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testReturnUserByKey_notExists() {
		user = profileDAO.returnUserByKey("AAAAA", "BBBBB");
		assertNull(user);	
	}


	/**
	 * Test method for {@link model.DbProfileDAO#ChangePassword(model.Bean.UserBean)}.
	 */
	@Test
	final void testChangePassword() {
		boolean changed = profileDAO.changePassword(userExpected, user_password);
		assertTrue(changed);
		userActual = profileDAO.returnUserByKey(userExpected.getFiscal_code(), userExpected.getUser_password());
		assertEquals(userExpected.getUser_password(), userActual.getUser_password());
	}

}


