package daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import models.Reimbursement;
import models.ReimbursementStatus;
import models.Status;
import models.User;
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
			Reimbursement reimbursement = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			reimbursement = s.get(Reimbursement.class, id);
		}
		
		return reimbursement;
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
			List<Reimbursement> reimbursement = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			reimbursement = s.createQuery("from Reimbursement ", Reimbursement.class).list();
		}
		
		return reimbursement;
	}

	@Override
	public List<Reimbursement> getByAuthor(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setStatusByID(int id, User approverUser, ReimbursementStatus status) {
		// TODO Auto-generated method stub
		return false;
	}

}
