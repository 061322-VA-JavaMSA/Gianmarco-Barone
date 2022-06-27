package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Product;
import models.User;
import models.userInventory;
import util.ConnectionUtil;

public class UserInventoryPostgres implements UserInventoryDAO {

	

	
	@Override
	public userInventory getUserInventoryByUsername(String username) {
		String sql = "select * from User_inventory where User_id  = ?;";
		userInventory ui = null;
		
		try (Connection c = ConnectionUtil.getLocalConnection();){
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, username); // this refers to the 1st "?" in the sql string, allows to inject data

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ui = new userInventory();
				ui.setItemName(rs.getString("Item_name"));
				ui.setRemaining_payments(rs.getInt("remaining_payments"));
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ui;
	}
	
	@Override
	public List<userInventory> retrieveProductsByUserId(userInventory ui) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
