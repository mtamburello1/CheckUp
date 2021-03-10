package model.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Dao.UserDAO;

/**
 * This class implements the UserDAO interface, using the DataBase as persistence manager.
 * @author Tamburello Martina
 * @see UserDAO
 */

public class DbUserDAO implements UserDAO{

	/** Query for specializations. */
    private static final String SelectSpecializationsSQL = "SELECT specialization FROM user WHERE type_user='doctor' GROUP BY specialization ORDER BY specialization";
	
    
	/**
	 * @return the specializations of all doctors in the repository.
	 */
    @Override
    public ArrayList<String> getSpecializations() {
		ArrayList<String> specializations = new ArrayList<String>();
		Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
        	con = DbConnection.getConnection(); 
			preparedStatement = con.prepareStatement(SelectSpecializationsSQL);
			result = preparedStatement.executeQuery();
            while (result.next()) {
            	specializations.add(result.getString("specialization"));
            }  
            con.close();
            return specializations;
        }
        catch (SQLException e) {
            e.printStackTrace();        
        } 
       
        return null;
	}
    
    
    



}
