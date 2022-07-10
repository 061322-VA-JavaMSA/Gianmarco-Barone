package daos;

import java.util.List;

import models.Reimbursement;
import models.Status;


public interface ReimbursementDao {
	Reimbursement createReimbursement(Reimbursement r);
	Reimbursement getReimbursementById(int id);
	Reimbursement getReimbursementbyStatus(Status status);
	Reimbursement getReimbursementByUsername(String username);
	List<Reimbursement> getReimbursements();
}


