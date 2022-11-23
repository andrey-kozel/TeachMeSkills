package com.exmaple.springboot.repository;

import java.util.Optional;

import com.exmaple.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findUserByName(String name);
}
