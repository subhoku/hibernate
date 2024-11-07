package com.codeo.foreignkeyconcept.modal;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
public class Manager {
	   @Id
	     @GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
	     
	     @Column(name="name")
		private String name;
	     @OneToMany(mappedBy = "manager",cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	     @JoinColumn(name="manager_id", nullable = false)
		
	     private Set<Waiter> waiter=new HashSet<Waiter>();
	     
}
