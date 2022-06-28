package project0ShopDaos;

import java.util.List;

import project0ShopModels.customer;

public interface CustomerDAO {

	customer createCustomer(customer C);
	customer pullCustomerId(int id);
	List<customer> pullCustomers();
	customer pullBycustomer(String username,String password);
	boolean updateCustomer(customer C);
	boolean deleteCustomer(int id);
	
}
