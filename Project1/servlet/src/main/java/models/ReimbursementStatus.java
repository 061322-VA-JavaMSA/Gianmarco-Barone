package models;

import java.util.Objects;

public class ReimbursementStatus {

	private int id;
	private Status status;
	
	public ReimbursementStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementStatus other = (ReimbursementStatus) obj;
		return id == other.id && status == other.status;
	}
	@Override
	public String toString() {
		return "ReimbursementStatus [id=" + id + ", status=" + status + "]";
	}
	
	
}
