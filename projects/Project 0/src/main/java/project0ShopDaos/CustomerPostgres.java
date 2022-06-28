package project0ShopDaos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project0ShopModels.customer;
import project0ShopUtil.connectionUtil;

public class CustomerPostgres implements CustomerDAO {

	@Override
	public customer createCustomer(customer C) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public customer pullCustomerId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public  List<customer> pullCustomers() {
		String sql = "select * from customer_account";
		List<customer> customer = new ArrayList<>();
		
		try {Connection c = connectionUtil.connectionHardCoded();
			Statement statement = c.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				customer cust = new customer();
				cust.setCustomerId(result.getInt("customer_id"));
				cust.setUsername(result.getString("customer_username"));
				cust.setPassword(result.getString("customer_password"));
				customer.add(cust);
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return customer;
	}

	
	public customer pullBycustomer1(String username, String Password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCustomer(customer C) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCustomer(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public customer pullBycustomer(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
