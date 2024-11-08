package com.codeo.foreignkeyconcept.modal;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
public class Manager {
	   @Id
	     @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @SequenceGenerator(name = "manager_seq", sequenceName = "manager_sequence", allocationSize = 1)
		private long id;
	     
	     @Column(name="name")
		private String name;
	     @OneToMany(mappedBy = "manager",cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	   
		
	     private Set<Waiter> waiter=new HashSet<Waiter>();
	     
}
