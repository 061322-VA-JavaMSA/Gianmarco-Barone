package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reimbursement_status")
public class ReimbursementStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="reimbursement_status_id")
	private int id;
	@Column(name="reimbursement_status")
	private String reimbursementStatus;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReimbursementStatus() {
		return reimbursementStatus;
	}
	public void setReimbursementStatus(String reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}
	
	

}
