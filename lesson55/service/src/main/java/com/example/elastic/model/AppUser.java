package com.example.elastic.model;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Jacksonized
@Value
@Builder(toBuilder = true)
@Table("users")
public class AppUser {

  @Id
  Long id;

  @Column("name")
  String username;

  String password;
}
