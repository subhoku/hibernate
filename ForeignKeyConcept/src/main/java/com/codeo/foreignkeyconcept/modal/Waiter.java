package com.codeo.foreignkeyconcept.modal;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
@Table(name="waiter")
@Data
public class Waiter {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
     
     @Column(name="name")
	private String name;
     @ManyToOne(fetch=FetchType.LAZY)
     @JoinColumn(name="manager_id", nullable = false)
	private Manager manager;
}
