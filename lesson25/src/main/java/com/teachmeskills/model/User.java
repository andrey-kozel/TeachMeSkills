package com.teachmeskills.model;

import java.time.Instant;
import java.util.Date;

public class User {

  private Long id;
  private String name;
  private String role;
  private String password;
  private Date createdAt;

  public User(Long id, String name, String role, String password, Date createdAt) {
    this.id = id;
    this.name = name;
    this.role = role;
    this.password = password;
    this.createdAt = createdAt;
  }

  public String getName() {
    return name;
  }

  public Long getId() {
    return id;
  }

  public String getRole() {
    return role;
  }

  public String getPassword() {
    return password;
  }

  public Date getCreatedAt() {
    return createdAt;
  }
}
