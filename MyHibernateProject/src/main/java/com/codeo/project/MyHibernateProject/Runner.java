package com.codeo.project.MyHibernateProject;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Runner {

	public static void main(String[] args) {
		//create session from HibernateUtil
	
		Session session=HibernateUtil.getSessionFactory().openSession();
           Transaction transaction=null;
           transaction=session.beginTransaction();
           //example HQL to create a table
 String hql=""           
           
	}

}
