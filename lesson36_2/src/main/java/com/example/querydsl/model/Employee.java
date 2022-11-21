package com.example.querydsl.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "employee")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_seq")
  @SequenceGenerator(name = "employee_id_seq",
    sequenceName = "employee_id_seq", allocationSize = 1)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "last_name")
  private String lastName;

  @ToString.Exclude
  @ManyToOne
  private Organization organization;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id", referencedColumnName = "employee_id")
  private WorkingPlace workingPlace;

}
