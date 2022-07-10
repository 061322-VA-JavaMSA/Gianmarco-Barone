package daos;

import org.hibernate.Session;

import models.ReimbursementStatus;
import util.HibernateUtil;

public class ReimbursementStatusHibernate implements ReimbursementStatusDao {

	@Override
	public ReimbursementStatus getReimbursementStatusById(int id) {
		ReimbursementStatus status = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			status = s.get(ReimbursementStatus.class, id);
		}
		
		return status;
	}

}
