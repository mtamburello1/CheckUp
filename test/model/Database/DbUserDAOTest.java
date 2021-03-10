/**
 * 
 */
package model.Database;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Dao.UserDAO;

/**
 * @author Tamburello Martina
 *
 */
class DbUserDAOTest {

	UserDAO userDAO;
	ArrayList<String> specializations;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		userDAO = new DbUserDAO();
		specializations = new ArrayList<String>();
	}

	/**
	 * Test method for {@link model.DbUserDAO#getSpecializations()}.
	 */
	@Test
	void testGetSpecializations() {
		specializations = userDAO.getSpecializations();
		assertNotNull(specializations);
	}

}
