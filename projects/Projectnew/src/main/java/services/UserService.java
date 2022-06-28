package services;



import java.util.List;

import daos.UserDAO;
import daos.UserPostgres;
import models.User;

public class UserService {

	private UserDAO ud = new UserPostgres();
	
	
	public List<User> getUsers(){
		return ud.retrieveUsers();
	}
	
	public User createUser(User u) {
		
		User user = ud.createUser(u);
		System.out.println("User: " + user + " was created.");
		return user;
	}
	public User retrieveAuth() {
		User user = ud.retrieveAuth(0);
		System.out.println("Authorization level" + user);
		return user;
		
	}
}
