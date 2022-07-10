package services;

import daos.ReimbursementDao;
import daos.ReimbursementHibernate;
import exceptions.ReimbursementNotCreatedException;
import exceptions.UserNotCreatedException;
import models.Reimbursement;
import models.Status;
import models.User;

public class ReimbursementService {
	
	private ReimbursementDao rd = new ReimbursementHibernate();
	
	public Reimbursement createReimbursement(Reimbursement r) throws ReimbursementNotCreatedException {
		
		//r.setStatus(Status.pending);
		//r.setAuthorUsername(r.getAuthorUsername());
		
		Reimbursement newReimbursement = rd.createReimbursement(r);
		if(newReimbursement.getId() == -1) {
			throw new ReimbursementNotCreatedException();
		}
		return newReimbursement;
		
		
	}

}
