package com.example.elastic.repository;

import com.example.elastic.model.AppUser;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends Repository<AppUser, Long> {

  AppUser save(final AppUser user);

  @Query("SELECT * FROM users WHERE name = :username")
  AppUser get(@Param("username") final String username);
}
