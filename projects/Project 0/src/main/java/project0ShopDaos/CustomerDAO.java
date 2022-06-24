package project0ShopDaos;

import java.util.List;

import project0ShopModels.customer;

public interface CustomerDAO {

	customer createCustomer(customer C);
	customer pullCustomerId(int id);
	List<customer> pullCustomers();
	customer pullBycustomer(String username);
	boolean updateCustomer(customer C);
	boolean deleteCustomer(int id);
	
}
