package com.codeo.project.MyHibernateProject;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Runner {

	public static void main(String[] args) {
		//create session from HibernateUtil
	
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	     Session session=sessionFactory.openSession();
	     Transaction transaction=session.beginTransaction();
	     
	     Employee employee=new Employee();
	     employee.setEmp_id(1);
	     employee.setEmp_name("sudarshan");
	     employee.setEmp_salary(982372.32);
	     employee.setEmp_address("Nagpur");
	     employee.setEmp_mobileno("8237817366");
	   
	     
	     session.save(employee);
	     transaction.commit();
	     session.close();
	     sessionFactory.close();
	}

}
