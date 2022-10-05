package com.teachmeskills.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.teachmeskills.model.User;

public class JdbcUserRepository implements UserRepository {

  private final Connection connection;

  public JdbcUserRepository(Connection connection) {
    this.connection = connection;
  }

  @Override
  public List<User> findUsers() {
    try {
      Statement statement = connection.createStatement();
      String sql = "select name from users";
      ResultSet rs = statement.executeQuery(sql);
      final List<User> users = new ArrayList<>();
      while (rs.next()) {
        final User user = new User(rs.getString("name"));
        users.add(user);
      }

      return users;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
