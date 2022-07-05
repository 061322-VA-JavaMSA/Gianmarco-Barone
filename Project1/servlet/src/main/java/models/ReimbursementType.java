package models;

import java.util.Objects;

public class ReimbursementType {
	
	private int id;
	private String type;
	
	
	public ReimbursementType() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, type);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementType other = (ReimbursementType) obj;
		return id == other.id && Objects.equals(type, other.type);
	}


	@Override
	public String toString() {
		return "ReimbursementType [id=" + id + ", type=" + type + "]";
	}

	

}
