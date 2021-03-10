/**
 * 
 */
package control.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Tamburello Martina
 *
 */
class StringConverterTest {

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
	}

	/**
	 * Test method for {@link control.util.StringConverter#stringToDate(java.lang.String)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	final void testStringToDateSuccessfull() {
		java.sql.Date date = StringConverter.stringToDate("gen 24, 2021");
		assertEquals(new java.sql.Date(2021-1900, 1-1, 24), date);
	}
	
	/**
	 * Test method for {@link control.util.StringConverter#stringToDate(java.lang.String)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	final void testStringToDateSuccessfull2() {
		java.sql.Date date = StringConverter.stringToDate("gennaio 24, 2021");
		assertEquals(new java.sql.Date(2021-1900, 1-1, 24), date);
	}
	
	/**
	 * Test method for {@link control.util.StringConverter#stringToDate(java.lang.String)}.
	 */
	@Test
	final void testStringToDate_Failure() {
		java.sql.Date date = StringConverter.stringToDate("AAAAAOOPP");
		assertNull(date);
	}
	
	/**
	 * Test method for {@link control.util.StringConverter#stringToDate(java.lang.String)}.
	 */
	@Test
	final void testStringToDate_Failure2() {
		java.sql.Date date = StringConverter.stringToDate("gen 24,2cccs");
		assertNull(date);
	}
	
	/**
	 * Test method for {@link control.util.StringConverter#stringToDate(java.lang.String)}.
	 */
	@Test
	final void testStringToDate_Failure3() {
		java.sql.Date date = StringConverter.stringToDate("gen 24,1899");
		assertNull(date);
	}
	
	
	/**
	 * Test method for {@link control.util.StringConverter#dateStringToDate(java.lang.String)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	final void testDateStringToStringSuccessfull() {
		java.sql.Date date = StringConverter.dateStringToDate("2021-01-24");
		assertEquals(new java.sql.Date(2021-1900, 1-1, 24), date);
	}
	
	/**
	 * Test method for {@link control.util.StringConverter#dateStringToDate(java.lang.String)}.
	 */
	@Test
	final void testDateStringToString_Failure() {
		java.sql.Date date = StringConverter.dateStringToDate("AAAAA");
		assertNull(date);
	}

	
	/**
	 * Test method for {@link control.util.StringConverter#dateStringToDate(java.lang.String)}.
	 */
	@Test
	final void testDateStringToString_Failure2() {
		java.sql.Date date = StringConverter.dateStringToDate("2090000-12-01");
		assertNull(date);
	}
	
	/**
	 * Test method for {@link control.util.StringConverter#dateStringToDate(java.lang.String)}.
	 */
	@Test
	final void testDateStringToString_Failure3() {
		java.sql.Date date = StringConverter.dateStringToDate("1899-12-01");
		assertNull(date);
	}
}
