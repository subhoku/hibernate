package com.codeo.project.HibernateUsingAnnotations;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity  // Use javax.persistence.Entity
@Table(name="carpenter")
public class Carpenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carpenter_id;
    private String carpenter_name;
    private int carpenter_experience;
    private String carpenter_specialization;
}
