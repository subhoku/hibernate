package com.codeo.project.HibernateUsingAnnotations;

import java.util.Properties;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class CarpenterApp {

	public static void main(String[] args) {
		//create hibernate configuration object
		Configuration configuration=new Configuration();
		//configure the properties for hibernate here only
		Properties properties=new Properties();
		properties.put("hibernate.connection.drivrler_class", "oracle.jdbc.OracleDriver");
        properties.put("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521/XE");
        properties.put("hibernate.connection.username", "system");
        properties.put("hibernate.connection.password", "tiger");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.show_sql", "true");
        //add the properties to the configurationobject
        configuration.setProperties(properties);
        //add annotated class
        configuration.addAnnotatedClass(Carpenter.class);
        //build a service registry
        StandardServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        //create SessionFactory
        SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
        //open session
        Session session=sessionFactory.openSession();
        //begin transaction
        Transaction tx=session.beginTransaction();
        //insert data into carpenter table
        Carpenter carpenter=new Carpenter();
        carpenter.setCarpenter_id(1);
        carpenter.setCarpenter_experience(2);
        carpenter.setCarpenter_name("sudarshan");
        carpenter.setCarpenter_specialization("Furniture");
        session.save(carpenter);
        //commit transaction
        tx.commit();
        //close the session
        session.close();
        sessionFactory.close();
        
	}

}
