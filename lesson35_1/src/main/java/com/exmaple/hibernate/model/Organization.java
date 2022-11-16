package com.exmaple.hibernate.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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

  @OneToMany
  @JoinColumn(name = "organization_id")
  @Cascade(CascadeType.ALL)
  private List<Employee> employees;

}
