package com.codeo.foreignkeyconcept;

import com.codeo.foreignkeyconcept.modal.Manager;
import com.codeo.foreignkeyconcept.modal.Waiter;
import com.codeo.foreignkeyconcept.repo.ManagerRepository;
import com.codeo.foreignkeyconcept.repo.WaiterRepository;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Runner {

    public static void main(String[] args) {
        // Load Hibernate configuration from hibernate.cfg.xml
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
        ManagerRepository managerRepository = new ManagerRepository(sessionFactory);
        WaiterRepository waiterRepository = new WaiterRepository(sessionFactory);

        try {
            // Create a new Manager
            Manager manager = new Manager();
            manager.setName("Sudarshan");

            // Create a new Waiter and set the manager
            Waiter waiter = new Waiter();
            waiter.setName("Rajat");
            waiter.setManager(manager);

            // Add the waiter to the manager's set of waiters
            manager.getWaiter().add(waiter);

            // Save manager and waiter
            System.out.println("Saving manager and waiter...");
            managerRepository.saveManager(manager);
            waiterRepository.saveWaiter(waiter);

            // Fetch and update manager
            System.out.println("Fetching and updating manager...");
            Manager fetchedManager = managerRepository.getManager(manager.getId());
            if (fetchedManager != null) {
                System.out.println("Manager Name: " + fetchedManager.getName());
                fetchedManager.setName("Updated Manager Name");
                managerRepository.UpdateManager(fetchedManager);
            }

            // Delete waiter and manager
            System.out.println("Deleting waiter and manager...");
            waiterRepository.deleteWaiter(waiter.getId());
            managerRepository.deleteManager(manager.getId());

        } finally {
            // Close the SessionFactory
            sessionFactory.close();
            System.out.println("SessionFactory closed.");
        }
    }
}
