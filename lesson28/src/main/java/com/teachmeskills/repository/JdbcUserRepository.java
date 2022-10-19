package com.teachmeskills.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.teachmeskills.model.User;

public class JdbcUserRepository implements UserRepository {

  private final Connection connection;

  public JdbcUserRepository(Connection connection) {
    this.connection = connection;
  }

  @Override
  public List<User> findUsers() {
    try (
      Statement statement = connection.createStatement();
    ) {

      String sql = "select id, name, role, password, created_at from users";
      ResultSet rs = statement.executeQuery(sql);
      final List<User> users = new ArrayList<>();
      while (rs.next()) {
        users.add(buildUser(rs));
      }

      return users;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Optional<User> getUser(String name) {
    try (
      PreparedStatement statement = connection.prepareStatement(
        "select id, name, role, password, created_at from users where name = ?")
    ) {

      statement.setString(1, name);
      ResultSet rs = statement.executeQuery();

      if (rs.next()) {
        return Optional.of(buildUser(rs));
      }

      return Optional.empty();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void createUser(String name, String password, String role) {
    try (
      PreparedStatement statement = connection.prepareStatement(
        "insert into users (name, role, password) values (?, ?, ?)")
      ) {
      statement.setString(1, name);
      statement.setString(2, role);
      statement.setString(3, password);
      statement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private User buildUser(ResultSet rs) throws SQLException {
    return new User(
      rs.getLong("id"),
      rs.getString("name"),
      rs.getString("role"),
      rs.getString("password"),
      rs.getTimestamp("created_at")
    );
  }

}
