package com.exmaple.security.service;

import com.exmaple.security.client.UserClient;
import com.exmaple.security.client.dto.AppUserDto;
import com.exmaple.security.client.dto.CreateUserDto;
import com.exmaple.security.client.dto.VerifyResultDto;
import com.exmaple.security.client.dto.VerifyUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserClient userClient;

  public AppUserDto getUser(final String username) {
    return userClient.getUser(username);
  }

  public AppUserDto saveUser(final AppUserDto user) {
    final CreateUserDto request = CreateUserDto.builder()
      .login(user.getUsername())
      .password(user.getPassword())
      .build();

    return userClient.saveUser(request);
  }

  public VerifyResultDto verifyUser(final String username, final String password) {
    final VerifyUserDto request = VerifyUserDto.builder()
      .login(username)
      .password(password)
      .build();

    return userClient.verifyUser(request);
  }
}
