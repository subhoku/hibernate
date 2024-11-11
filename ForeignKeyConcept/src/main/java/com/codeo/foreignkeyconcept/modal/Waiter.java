package com.codeo.foreignkeyconcept.modal;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "waiter")
@Getter
@Setter
public class Waiter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "waiter_seq")
    @SequenceGenerator(name = "waiter_seq", sequenceName = "waiter_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", nullable = false)
    private Manager manager;
    // 'manager' is a reference to the Manager entity that this Waiter reports to.
}
