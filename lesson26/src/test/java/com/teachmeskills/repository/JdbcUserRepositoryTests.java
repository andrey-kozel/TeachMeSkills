package com.teachmeskills.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.teachmeskills.model.User;
import org.assertj.core.api.Assertions;
import org.junit.ClassRule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(Lifecycle.PER_CLASS)
class JdbcUserRepositoryTests {

  @ClassRule
  final GenericContainer container = new PostgreSQLContainer("postgres:13.4")
    .withUsername("postgres")
    .withPassword("postgres")
    .withDatabaseName("postgres")
    .withInitScript("init.sql")
    .withExposedPorts(5432);

  private Connection connection;
  private JdbcUserRepository repository;

  @BeforeAll
  public void init() throws ClassNotFoundException, SQLException {
    container.start();
    final String dbDriver = "org.postgresql.Driver";
    final String username = "postgres";
    final String password = "postgres";
    final String dbUrl = "jdbc:postgresql://localhost:" + container.getMappedPort(5432) + "/postgres";

    Class.forName(dbDriver);
    connection = DriverManager.getConnection(dbUrl, username, password);
    repository = new JdbcUserRepository(connection);
  }

  @Test
  void createUser() {
    List<User> users = repository.findUsers();

    assertThat(users)
      .hasSize(5);
  }
}
