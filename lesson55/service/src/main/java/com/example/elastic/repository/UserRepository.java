package com.example.elastic.repository;

import java.util.List;

import com.example.elastic.model.AppUser;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends Repository<AppUser, Long> {

  AppUser save(final AppUser user);

  @Query("SELECT * FROM users WHERE name = :username")
  AppUser get(@Param("username") final String username);

  @Query("SELECT * FROM users WHERE id IN (:ids)")
  List<AppUser> findByUserIds(@Param("ids") final List<Long> ids);
}
