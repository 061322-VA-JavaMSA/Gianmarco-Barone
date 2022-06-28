package project0ShopModels;

import java.util.Objects;

public class employee {
	
	private int employeeId;
	private String username;
	private String password;
	public employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "employee [employeeId=" + employeeId + ", usernmae=" + username + ", password=" + password + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(employeeId, password, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		employee other = (employee) obj;
		return employeeId == other.employeeId && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getUsernmae() {
		return username;
	}
	public void setUsernmae(String usernmae) {
		this.username = usernmae;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
