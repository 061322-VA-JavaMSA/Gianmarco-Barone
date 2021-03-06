package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Offer;
import models.User;
import util.ConnectionUtil;

public class OfferPostgres implements OfferDAO {

	@Override
	public Offer createOffer(Offer o) {
		String sql = "insert into Offers (Offer_amount, Product_id,Offer_username) values (?,?,?) returning Offer_id;";
		try(Connection c = ConnectionUtil.getLocalConnection()){
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, o.getOfferAmount());
			ps.setInt(2, o.getProductId());
			ps.setString(3, o.getUsername());
			
			ResultSet rs = ps.executeQuery(); // return the id generated by the database
			if(rs.next()) {
				o.setOfferId(rs.getInt("Offer_id"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}

	@Override
	public Offer retrieveOfferByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
