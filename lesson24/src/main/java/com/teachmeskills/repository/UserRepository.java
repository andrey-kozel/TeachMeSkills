package com.teachmeskills.repository;

import java.util.List;

import com.teachmeskills.model.User;

public interface UserRepository {

  List<User> findUsers();

}
