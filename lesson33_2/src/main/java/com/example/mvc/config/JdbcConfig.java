package com.example.mvc.config;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JdbcConfig {

  @Bean
  public Connection connection(
    @Value("${driverClassname}") final String driveClassName,
    @Value("${databaseUrl}") final String databaseUrl,
    @Value("${username}") final String username,
    @Value("${password}") final String password
  ) throws SQLException {
    System.out.println(driveClassName);
    final DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(driveClassName);
    dataSource.setUrl(databaseUrl);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    return dataSource.getConnection();
  }

}
