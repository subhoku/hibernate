package com.codeo.foreignkeyconcept.repo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;

import com.codeo.foreignkeyconcept.modal.Manager;
import com.codeo.foreignkeyconcept.modal.Waiter;
import com.codeo.project.MyHibernateProject.HibernateUtil;

public class ManagerRepository {

	public ManagerRepository(SessionFactory sessionFactory) {
		
	}
	public void saveManager(Manager manager) {
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			transaction=session.beginTransaction();
			session.save(manager);
			transaction.commit();
		}
		catch(TransactionException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
public void UpdateManager(Manager manager) {
	Transaction transaction=null;
	try(Session session=HibernateUtil.getSessionFactory().openSession())
	{
		transaction=session.beginTransaction();
		session.update(manager);
		transaction.commit();
		
	}
	catch(TransactionException e) {
		e.printStackTrace();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	}
public void deleteManager(long id) {
	Transaction transaction=null;
	try(Session session=HibernateUtil.getSessionFactory().openSession())
	{
		transaction=session.beginTransaction();
		Manager manager=session.get(Manager.class, id);
		if(manager!=null) {
			session.delete(manager);
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
public Manager getManager(long id) {
	try(Session session=HibernateUtil.getSessionFactory().openSession())
			{
	return session.get(Manager.class, id);
			}
}


}
