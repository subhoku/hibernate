package com.codeo.project.MyHibernateProject;

import java.io.Serializable;

import javax.persistence.Table;

import org.hibernate.annotations.Entity;

import lombok.Data;

@Entity
@Table(name = "employeex")
@Data
public class Employee implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private int emp_id;
	private String emp_name;
	private double emp_salary;
	private String emp_address;
    private String emp_mobileno;
	
}
