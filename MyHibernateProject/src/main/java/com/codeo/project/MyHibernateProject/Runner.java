package com.codeo.project.MyHibernateProject;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Runner {

	public static void main(String[] args) {
		//create session from HibernateUtil
	
		Configuration config=new Configuration();
		////activates the hibernate framework based of jar files that are added
		config.configure("hibernate.cfg.xml");
		//here configure(-) method loads the given hibernate cfg file
		//it will check it is wellformed or not also creattes 
		//meta data and even stores same info in config class object
	     SessionFactory factory=config.buildSessionFactory();
	     //all above hiberante session factory will be created as complex heavy obj
	     //and return the object
	     Session session=factory.openSession();
	     Transaction tx=session.beginTransaction();
	     Employee employee=new Employee();
	     employee.setEmp_id(1);
	     employee.setEmp_name("sudarshan");
	     employee.setEmp_salary(982372.32);
	     employee.setEmp_address("Nagpur");
	     employee.setEmp_mobileno("8237817366");
	   
	     
	     session.save(employee);
	     //This method gives persistence instruction to save object and also
	     //returns either assigned or generated identity value back to app as return value
	     
	     tx.commit();
	     //takes all the persistence instruction that given 
	     //through session object completes them by
	     //executing jdbc code+SQL Queries in database coftware
	     session.close();
	     //closses the con between db and returns conn object
	     //vanishes the Dailect, O-r mapping metadata
	     factory.close();
	     //closes the session factory
	     //vanishes all obj that associate with Session Factory object
	}

}
