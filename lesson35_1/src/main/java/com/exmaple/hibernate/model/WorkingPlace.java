package com.exmaple.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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
