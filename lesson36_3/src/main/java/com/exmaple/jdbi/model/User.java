package com.exmaple.jdbi.model;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Table(name = "users")
public class User {

  @Id
  private Long id;

  @Column("name")
  private String name;

  @Column("role")
  private String role;

  @Column("password")
  private String password;

  @Column("created_at")
  private Date createdAt;

  public User(final String name, final String password, final String role) {
    this.name = name;
    this.password = password;
    this.role = role;
  }

}
