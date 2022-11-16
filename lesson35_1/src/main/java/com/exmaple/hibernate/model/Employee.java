package com.exmaple.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "employee")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_seq")
  @SequenceGenerator(name="employee_id_seq",
    sequenceName="employee_id_seq", allocationSize=1)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "last_name")
  private String lastName;

  @ToString.Exclude
  @ManyToOne
  private Organization organization;

  @OneToOne
  @JoinColumn(name = "id", referencedColumnName = "employee_id")
  private WorkingPlace workingPlace;

}
