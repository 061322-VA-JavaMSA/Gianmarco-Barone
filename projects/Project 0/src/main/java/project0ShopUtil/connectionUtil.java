package project0ShopUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionUtil {
	// this line allows the reuse of c instead of creating new connections
	private static Connection c;
	//work on connecting to the database using a file
	public static Connection
	
}

 	/*this connects to the database
 	 * is the hard coded way of doing things not good practice
	String url = "jdbc:postgresql://localhost:5432/postgres";
	String username = "postgres";
	String password = "";
	
	try {
		Connection c = DriverManager.getConnection(url,username,password);
		//put what it is you want to retrieve
		System.out.println(c.getMetaData().getDriverName());
		c.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}

}*/
	
	
