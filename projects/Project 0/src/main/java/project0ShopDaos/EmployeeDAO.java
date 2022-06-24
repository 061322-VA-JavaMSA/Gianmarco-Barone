package project0ShopDaos;

import java.util.List;


import project0ShopModels.employee;
import project0ShopModels.product;

public interface EmployeeDAO {

	employee pullemployeeId(int id);
	List<employee> pullemployee();
	employee pullByemployee(String username);
	product pullPending(int pending);
	boolean  pendingOfferChoice(int choice);
	product addProduct(String addItem);
}
