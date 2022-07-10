package dtos;






public class CreateReimbursementDto {

	
	private int id;
	private int amount;
	private String description;
	private int authorId;
	private int resolverId;	
	private int  reimbursementStatusId;
	private int reimbursementTypeId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public int getResolverId() {
		return resolverId;
	}
	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}
	public int getReimbursementStatusId() {
		return reimbursementStatusId;
	}
	public void setReimbursementStatusId(int reimbursementStatusId) {
		this.reimbursementStatusId = reimbursementStatusId;
	}
	public int getReimbursementTypeId() {
		return reimbursementTypeId;
	}
	public void setReimbursementTypeId(int reimbursementTypeId) {
		this.reimbursementTypeId = reimbursementTypeId;
	}
	@Override
	public String toString() {
		return "CreateReimbursementDto [id=" + id + ", amount=" + amount + ", description=" + description
				+ ", authorId=" + authorId + ", resolverId=" + resolverId + ", reimbursementStatusId="
				+ reimbursementStatusId + ", reimbursementTypeId=" + reimbursementTypeId + "]";
	}
	
	
	
}
