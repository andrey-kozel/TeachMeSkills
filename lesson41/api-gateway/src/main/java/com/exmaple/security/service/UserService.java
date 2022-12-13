package com.exmaple.security.service;

import com.exmaple.security.client.UserClient;
import com.exmaple.security.client.dto.CreateUserDto;
import com.exmaple.security.client.dto.VerifyUserDto;
import com.exmaple.security.model.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserClient userClient;

  public AppUser getUser(final String username) {
    return userClient.getUser(username);
  }

  public AppUser saveUser(final AppUser user) {
    final CreateUserDto request = CreateUserDto.builder()
      .login(user.getUsername())
      .password(user.getPassword())
      .build();

    return userClient.saveUser(request);
  }

  public AppUser verifyUser(final String username, final String password) {
    final VerifyUserDto request = VerifyUserDto.builder()
      .login(username)
      .password(password)
      .build();

    return userClient.verifyUser(request);
  }
}
