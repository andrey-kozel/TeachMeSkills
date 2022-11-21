package com.example.querydsl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "working_place")
public class WorkingPlace {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "working_place_id_seq")
  @SequenceGenerator(name="working_place_id_seq",
    sequenceName="working_place_id_seq", allocationSize=1)
  private Long id;

  @Column(name = "inventory_number")
  private String inventoryNumber;

  @ToString.Exclude
  @OneToOne
  private Employee employee;

}
