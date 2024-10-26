package com.codeo.project.UpdateusingXml;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="courses")
@Data
@AllArgsConstructor
public class Courses {
     @Id
     @Column(name="course_id")
	private int course_id;
	private String course_name;
	private double course_fees;
}
