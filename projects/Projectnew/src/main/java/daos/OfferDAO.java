package daos;

import models.Offer;
import models.User;

public interface OfferDAO {
	Offer createOffer(Offer o);
	Offer retrieveOfferByUsername(String username);
}
	
