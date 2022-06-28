package project0ShopServices;



import project0ShopDaos.CustomerDAO;
import project0ShopDaos.CustomerPostgres;
import project0ShopExceptions.LoginException;
import project0ShopModels.customer;

public class AuthorizeService {

	private CustomerDAO cd = new CustomerPostgres();
	
	public customer login(String username, String password) throws LoginException {
		
		if(username == null || password == null) {
			throw new LoginException();
			
		}
		customer cust = cd.pullBycustomer(username,password);
		
		if(cust == null || !cust.getPassword().equals(password)) {
			throw new LoginException();
		}else{
		
			System.out.println("you have an account");
			}
		
		return cust;
	}
}
