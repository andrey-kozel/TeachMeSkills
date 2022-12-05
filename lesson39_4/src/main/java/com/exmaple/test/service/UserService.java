package com.exmaple.test.service;

import com.exmaple.test.dto.UpdateUserDto;
import com.exmaple.test.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

  public UserDto get(final Long userId) {
    log.info("Get user. Id=[{}]", userId);
    return UserDto.builder()
      .id(userId)
      .firstName("First")
      .lastName("Last")
      .password("Pass")
      .build();
  }

  public void save(final UpdateUserDto dto) {
    log.info("Create user. Dto=[{}]", dto);
  }

  public void update(final Long userId, final UpdateUserDto dto) {
    log.info("Update user. Id=[{}] Dto=[{}]", userId, dto);
  }

  public void delete(final Long userId) {
    log.info("Delete user. Id=[{}]", userId);
  }
}
