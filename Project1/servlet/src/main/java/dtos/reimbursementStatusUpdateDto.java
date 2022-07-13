package dtos;

import java.sql.Timestamp;

import models.Reimbursement;
import models.ReimbursementStatus;
import models.ReimbursementType;
import models.User;

public class reimbursementStatusUpdateDto {
	
	private int id;
	private User resolver;
	private ReimbursementStatus  reimbursementStatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getResolver() {
		return resolver;
	}
	public void setResolver(User resolver) {
		this.resolver = resolver;
	}
	public ReimbursementStatus getReimbursementStatus() {
		return reimbursementStatus;
	}
	public void setReimbursementStatus(ReimbursementStatus reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}
	@Override
	public String toString() {
		return "reimbursementStatusUpdateDto [id=" + id + ", resolver=" + resolver + ", reimbursementStatus="
				+ reimbursementStatus + "]";
	}

	
	

	

}
