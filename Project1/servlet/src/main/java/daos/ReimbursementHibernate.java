package daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import exceptions.LoginException;
import models.Reimbursement;
import models.Status;
import util.HibernateUtil;

public class ReimbursementHibernate implements ReimbursementDao {

	@Override
	public Reimbursement createReimbursement(Reimbursement r) {
		r.setId(-1);
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			int id = (int) s.save(r);
			r.setId(id);
			tx.commit();	
		} catch(ConstraintViolationException e) {
			//LOG THIS
		}
		return r;
	}

	@Override
	public Reimbursement getReimbursementById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement getReimbursementbyStatus(Status status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement getReimbursementByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursements() {
		// TODO Auto-generated method stub
		return null;
	}

}
