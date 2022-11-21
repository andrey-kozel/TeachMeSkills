package com.example.querydsl.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "organization")
public class Organization {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organization_id_seq")
  @SequenceGenerator(name = "organization_id_seq",
    sequenceName = "organization_id_seq", allocationSize = 1)
  private Long id;

  @Column(name = "name")
  private String name;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "organization_id")
  private List<Employee> employees;

}
