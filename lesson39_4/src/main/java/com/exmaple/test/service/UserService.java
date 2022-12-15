package com.exmaple.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.exmaple.test.dto.UpdateUserDto;
import com.exmaple.test.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

  private final AtomicLong idSequence = new AtomicLong();
  private final List<UserDto> users = new ArrayList<>();

  public List<UserDto> getAll() {
    return users;
  }

  public UserDto get(final Long userId) {
    return users.stream()
      .filter(u -> u.getId().equals(userId))
      .findFirst()
      .orElse(null);
  }

  public void save(final UpdateUserDto dto) {
    final UserDto user = UserDto.builder()
      .id(idSequence.incrementAndGet())
      .firstName(dto.getFirstName())
      .lastName(dto.getLastName())
      .password(dto.getPassword())
      .build();

    users.add(user);
  }

  public void update(final Long userId, final UpdateUserDto dto) {
    UserDto userDto = get(userId);
    users.remove(userDto);
    final UserDto user = UserDto.builder()
      .id(userDto.getId())
      .firstName(dto.getFirstName())
      .lastName(dto.getLastName())
      .password(dto.getPassword())
      .build();

    users.add(user);
  }

  public void delete(final Long userId) {
    UserDto userDto = get(userId);
    users.remove(userDto);
  }
}
