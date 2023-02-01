package com.java.example.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class UserEntity {

  @Id
  private long id;

  @Column
  private String name;

  @Column
  private String role;

  @Column
  private String password;

  @Column
  private Instant createdAt;

}
