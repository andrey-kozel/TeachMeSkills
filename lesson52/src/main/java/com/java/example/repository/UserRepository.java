package com.java.example.repository;

import java.util.List;

import com.java.example.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

  @Query("SELECT e FROM UserEntity e ORDER BY e.id ASC")
  Page<UserEntity> getOffsetUsers(final Pageable page);

  @Query(value = "SELECT * FROM users u WHERE u.id > :idOffset LIMIT :pageSize", nativeQuery = true)
  List<UserEntity> getFilteredUsers(@Param("idOffset") final long idOffset, @Param("pageSize") final int pageSize);
}
