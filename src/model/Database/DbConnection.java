package model.Database;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.TimeZone;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

/**
 * This class instantiates a Singleton object that will be shared by all the components that will access the DataBase.
 * @author Tamburello Martina
 */

public class DbConnection {

	private static DataSource ds;

	/**
	 * 
	 * @return Connection the connection to db.
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		if (ds == null) {
			PoolProperties p = new PoolProperties();
			p.setUrl(
					"jdbc:mysql://127.0.0.1:3306/CheckUpDb?serverTimezone=" + TimeZone.getDefault().getID());
			p.setDriverClassName("com.mysql.cj.jdbc.Driver");
			p.setUsername("root");
			p.setPassword("martina");
			p.setMaxActive(100);
			p.setInitialSize(10);
			p.setMinIdle(10);
			p.setRemoveAbandonedTimeout(60);
			p.setRemoveAbandoned(true);
			ds = new DataSource();
			ds.setPoolProperties(p);
		}
		return ds.getConnection();
	}

}
