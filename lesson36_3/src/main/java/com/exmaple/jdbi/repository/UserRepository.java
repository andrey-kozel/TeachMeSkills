package com.exmaple.jdbi.repository;

import java.util.List;
import java.util.Optional;

import com.exmaple.jdbi.model.User;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends Repository<User, Long> {

  @Query("select * from users")
  List<User> findAll();

  @Query("select * from users where name = :name")
  Optional<User> findUserByName(@Param("name") String name);

  @Modifying
  @Query("insert into users (name, role, password) VALUES (:name, :password, :role)")
  void save(@Param("name") final String name, @Param("password") final String password, @Param("role") final String role);
}
