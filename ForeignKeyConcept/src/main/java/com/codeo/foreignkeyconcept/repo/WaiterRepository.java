package com.codeo.foreignkeyconcept.repo;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;

import com.codeo.foreignkeyconcept.modal.Waiter;
import com.codeo.project.MyHibernateProject.HibernateUtil;

public class WaiterRepository {

public void saveWaiter(Waiter waiter) {
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			transaction=session.beginTransaction();
			session.save(waiter);
			transaction.commit();
		}
		catch(TransactionException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
public void UpdateWaiter(Waiter waiter) {
	Transaction transaction=null;
	try(Session session=HibernateUtil.getSessionFactory().openSession())
	{
		transaction=session.beginTransaction();
		session.update(waiter);
		transaction.commit();
		
	}
	catch(TransactionException e) {
		e.printStackTrace();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	}
public void deleteWaiter(long id) {
	Transaction transaction=null;
	try(Session session=HibernateUtil.getSessionFactory().openSession())
	{
		transaction=session.beginTransaction();
		Waiter waiter=session.get(Waiter.class, id);
		if(waiter!=null) {
			session.delete(waiter);
			transaction.commit();
		}
		
	}
	catch(TransactionException e) {
		e.printStackTrace();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}

}
