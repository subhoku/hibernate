package com.codeo.project.UpdateusingXml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        // Load Hibernate configuration file
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        // Build SessionFactory
        SessionFactory sf = configuration.buildSessionFactory();
        
        // Open Session
        Session session = sf.openSession();
        
        // Begin Transaction
        Transaction tx = session.beginTransaction();
        
        // Create Course instance
        Courses courses = new Courses(1, "Blockchain", 23456);
        
        // Update course in the database
        session.update(courses);
        session.delete(courses);
        
        // Commit Transaction
        tx.commit();
        
        // Close Session
        session.close();
        
        // Close SessionFactory
        sf.close();
    }
}
