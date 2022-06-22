package project0ShopUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class connectionUtil {
	// this line allows the reuse of c instead of creating new connections
	private static Connection c;
	//work on connecting to the database using a file
	
	public static Connection getConnectionFromFile() throws SQLException, IOException {
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		prop.load(loader.getResourceAsStream("connection.properties"));
		
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		if (c == null || c.isClosed()) {
			c = DriverManager.getConnection(url, username, password);
			
		}
		return c;
	}

 	//this connects to the database
 	 //is the hard coded way of doing things not good practice
	
	
	/*try {
		Connection c = DriverManager.getConnection(url,username,password);
		//put what it is you want to retrieve
		System.out.println(c.getMetaData().getDriverName());
		c.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}*/

}
	
	
