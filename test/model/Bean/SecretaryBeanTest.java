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
class SecretaryBeanTest {

	SecretaryBean secretary;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		secretary = null;
	}

	/**
	 * Test method for {@link model.Bean.SecretaryBean#SecretaryBean()}.
	 */
	@Test
	void testSecretaryBeanEmptyConstructor() {
		secretary = new SecretaryBean();
		assertNotNull(secretary);
		
	}

	/**
	 * Test method for {@link model.Bean.SecretaryBean#SecretaryBean(java.lang.String, java.lang.String, java.lang.String, java.sql.Date, java.lang.String, java.lang.String, java.lang.String, java.lang.integer, java.lang.String)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	void testSecretaryBeanConstructor() {
		secretary = new SecretaryBean("NRPSQL70Y67U987O", "Pasquale", "Neri", new Date(1970-1900, 12-1, 9), "Salerno", "Salerno", "martina",  12345678, "pasquale@checkUp.it");
		assertEquals("NRPSQL70Y67U987O", secretary.getFiscal_code());
		assertEquals("Pasquale", secretary.getUser_name());
		assertEquals("Neri", secretary.getSurname());
		assertEquals(new Date(1970-1900, 12-1, 9), secretary.getBirth_date());
		assertEquals("Salerno", secretary.getBirth_place());
		assertEquals("Salerno", secretary.getResidence());
		assertEquals("martina", secretary.getUser_password());
		assertEquals(12345678, secretary.getPhone_number());
		assertEquals("pasquale@checkUp.it", secretary.getEmail());
	}

	/**
	 * Test method for {@link model.Bean.SecretaryBean#SecretaryBean(java.lang.String, java.lang.String, java.lang.String, java.sql.Date, java.lang.String, java.lang.String, java.lang.integer, java.lang.String)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	void testSecretaryBeanConstructor2() {
		secretary = new SecretaryBean("NRPSQL70Y67U987O", "Pasquale", "Neri", new Date(1970-1900, 12-1, 9), "Salerno", "Salerno", 12345678, "pasquale@checkUp.it");
		assertEquals("NRPSQL70Y67U987O", secretary.getFiscal_code());
		assertEquals("Pasquale", secretary.getUser_name());
		assertEquals("Neri", secretary.getSurname());
		assertEquals(new Date(1970-1900, 12-1, 9), secretary.getBirth_date());
		assertEquals("Salerno", secretary.getBirth_place());
		assertEquals("Salerno", secretary.getResidence());
		assertEquals(12345678, secretary.getPhone_number());
		assertEquals("pasquale@checkUp.it", secretary.getEmail());
	}
}
