package com.codeo.foreignkeyconcept;

import com.codeo.foreignkeyconcept.modal.Manager;
import com.codeo.foreignkeyconcept.modal.Waiter;
import com.codeo.foreignkeyconcept.repo.ManagerRepository;
import com.codeo.foreignkeyconcept.repo.WaiterRepository;

public class Runner {

	public static void main(String[] args) {
		ManagerRepository managerRepository=new ManagerRepository();
		WaiterRepository waiterRepository=new WaiterRepository();
		//create new Manager
		Manager manager=new Manager();
		manager.setName("sudarshan");
		//create a new waiter and set the manager
		Waiter waiter=new Waiter();
		waiter.setName("Rajat");
		waiter.setManager(manager);

	    //add the waiter to manager's set of waiter
		manager.getWaiter().add(waiter);
		//save manager and waiter
		managerRepository.saveManager(manager);
		waiterRepository.saveWaiter(waiter);
		//fetch and update manager
		Manager fetchManager=managerRepository.getManager(manager.getId());
		System.out.println("Manager Name::"+fetchManager.getName());
		fetchManager.setName("Update Manager 1");
		managerRepository.UpdateManager(fetchManager);
		//deleting waiter and manager
		waiterRepository.deleteWaiter(waiter.getId());
		managerRepository.deleteManager(manager.getId());
	}

}
