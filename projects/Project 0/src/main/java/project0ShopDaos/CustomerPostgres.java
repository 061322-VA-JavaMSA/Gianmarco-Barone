package project0ShopDaos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project0ShopModels.customer;
import project0ShopUtil.connectionUtil;

public class CustomerPostgres {

	
	public List<customer> pullCustomers() {
		String sql = "select * from customer_account;";
		List<customer> users = new ArrayList<>();
		
		try(Connection c = connectionUtil.connectionHardCoded()){
			// no user input taken, no need for prepared statement
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				// extract each field from rs for each record, map them to a User object and add them to the users arraylist
				customer u = new customer();
				u.CustomerId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				
				customer.add(cust);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
}
