/**
 * 
 */
package model.Bean;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Tamburello Martina
 *
 */
class UserBeanTest {

	UserBean user;
	UserBean user2;
	UserBean user3;

	/**
	 * @throws java.lang.Exception
	 */
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		user2 = new UserBean();
		user = new PatientBean("RSSMRO88N75U789K", "Mario", "Rossi", new Date(1998-1900,11-1,24), "Napoli", "Napoli","martina", 435464744, "marioRossi@live.it");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		user = null;
	}

	/**
	 * Test method for {@link model.Bean.UserBean#UserBean()}.
	 */
	@Test
	void testUserBeanEmptyConstructor() {
		user3 = new UserBean();
		assertNotNull(user3);
	}

	/**
	 * Test method for {@link model.Bean.UserBean#UserBean(java.lang.String, java.lang.String, java.lang.String, java.sql.Date, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	void testUserBeanConstructor() {
		user = new PatientBean("RSSMRO88N75U789K", "Mario", "Rossi", new Date(1998-1900,11-1,24), "Napoli", "Napoli","martina", 435464744, "marioRossi@live.it");
		assertEquals("RSSMRO88N75U789K", user.getFiscal_code());
		assertEquals("Mario", user.getUser_name());
		assertEquals("Rossi", user.getSurname());
		assertEquals(new Date(1998-1900,11-1,24), user.getBirth_date());
		assertEquals("Napoli", user.getBirth_place());
		assertEquals("Napoli", user.getResidence());
		assertEquals("martina", user.getUser_password());
		assertEquals(435464744, user.getPhone_number());
		assertEquals("marioRossi@live.it", user.getEmail());
	}

	/**
	 * Test method for {@link model.Bean.UserBean#UserBean(java.lang.String, java.lang.String, java.lang.String, java.sql.Date, java.lang.String, java.lang.String, int, java.lang.String)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	void testUserBeanConstructor2() {
		user = new PatientBean("RSSMRO88N75U789K", "Mario", "Rossi", new Date(1998-1900,11-1,24), "Napoli", "Napoli", 435464744, "marioRossi@live.it");
		assertEquals("RSSMRO88N75U789K", user.getFiscal_code());
		assertEquals("Mario", user.getUser_name());
		assertEquals("Rossi", user.getSurname());
		assertEquals(new Date(1998-1900, 11-1, 24), user.getBirth_date());
		assertEquals("Napoli", user.getBirth_place());
		assertEquals("Napoli", user.getResidence());
		assertNull(user.getUser_password());
		assertEquals(435464744, user.getPhone_number());
		assertEquals("marioRossi@live.it", user.getEmail());
	}

	/**
	 * Test method for {@link model.Bean.UserBean#getFiscal_code()}.
	 */
	@Test
	void testGetFiscal_code() {
		String fiscal_code = user.getFiscal_code();
		assertEquals("RSSMRO88N75U789K", fiscal_code);
	}

	/**
	 * Test method for {@link model.Bean.UserBean#setFiscal_code(java.lang.String)}.
	 */
	@Test
	void testSetFiscal_code() {
		user2.setFiscal_code("RSSMRO88N75U789K");
		assertEquals("RSSMRO88N75U789K",user2.getFiscal_code());
	}

	/**
	 * Test method for {@link model.Bean.UserBean#getUser_name()}.
	 */
	@Test
	void testGetUser_name() {
		String user_name = user.getUser_name();
		assertEquals("Mario", user_name);
	}

	/**
	 * Test method for {@link model.Bean.UserBean#setUser_name(java.lang.String)}.
	 */
	@Test
	void testSetUser_name() {
		user2.setUser_name("Mario");
		assertEquals("Mario", user2.getUser_name());
	}

	/**
	 * Test method for {@link model.Bean.UserBean#getSurname()}.
	 */
	@Test
	void testGetSurname() {
		String surname = user.getSurname();
		assertEquals("Rossi", surname);
	}

	/**
	 * Test method for {@link model.Bean.UserBean#setSurname(java.lang.String)}.
	 */
	@Test
	void testSetSurname() {
		user2.setSurname("Rossi");
		assertEquals("Rossi", user2.getSurname());
	}

	/**
	 * Test method for {@link model.Bean.UserBean#getBirth_date()}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	void testGetBirth_date() {
		Date birth_date = user.getBirth_date();
		assertEquals(new Date(1998-1900,11-1,24), birth_date);
	}

	/**
	 * Test method for {@link model.Bean.UserBean#setBirth_date(java.sql.Date)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	void testSetBirth_date() {
		user2.setBirth_date(new Date(1980-1900,10-1,18));
		assertEquals(new Date(1980-1900,10-1,18), user2.getBirth_date());
	}

	/**
	 * Test method for {@link model.Bean.UserBean#getBirth_place()}.
	 */
	@Test
	void testGetBirth_place() {
		String birth_place = user.getBirth_place();
		assertEquals("Napoli", birth_place);
	}

	/**
	 * Test method for {@link model.Bean.UserBean#setBirth_place(java.lang.String)}.
	 */
	@Test
	void testSetBirth_place() {
		user2.setBirth_place("Salerno");
		assertEquals("Salerno", user2.getBirth_place());
	}

	/**
	 * Test method for {@link model.Bean.UserBean#getResidence()}.
	 */
	@Test
	void testGetResidence() {
		String residence= user.getResidence();
		assertEquals("Napoli", residence);
	}

	/**
	 * Test method for {@link model.Bean.UserBean#setResidence(java.lang.String)}.
	 */
	@Test
	void testSetResidence() {
		user2.setResidence("Salerno");
		assertEquals("Salerno", user2.getResidence());
	}

	/**
	 * Test method for {@link model.Bean.UserBean#getUser_password()}.
	 */
	@Test
	void testGetUser_password() {
		String user_password = user.getUser_password();
		assertEquals("martina", user_password);
	}

	/**
	 * Test method for {@link model.Bean.UserBean#setUser_password(java.lang.String)}.
	 */
	@Test
	void testSetUser_password() {
		user2.setUser_password("Ciao");
		assertEquals("Ciao", user2.getUser_password());
	}

	/**
	 * Test method for {@link model.Bean.UserBean#getPhone_number()}.
	 */
	@Test
	void testGetPhone_number() {
		int phone_number = user.getPhone_number();
		assertEquals(435464744, phone_number);
	}

	/**
	 * Test method for {@link model.Bean.UserBean#setPhone_number(int)}.
	 */
	@Test
	void testSetPhone_number() {
		user2.setPhone_number(12343569);
		assertEquals(12343569, user2.getPhone_number());
	}

	/**
	 * Test method for {@link model.Bean.UserBean#getEmail()}.
	 */
	@Test
	void testGetEmail() {
		String email = user.getEmail();
		assertEquals("marioRossi@live.it", email);
	}

	/**
	 * Test method for {@link model.Bean.UserBean#setEmail(java.lang.String)}.
	 */
	@Test
	void testSetEmail() {
		user2.setEmail("marioRossi@checkUp.it");
		assertEquals("marioRossi@checkUp.it", user2.getEmail());
	}

}
