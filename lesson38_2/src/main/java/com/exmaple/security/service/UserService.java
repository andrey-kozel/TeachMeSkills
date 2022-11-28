package com.exmaple.security.service;

import com.exmaple.security.model.AppUser;
import com.exmaple.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public AppUser getUser(final Long id) {
    return userRepository.get(id);
  }

  public AppUser getUser(final String username) {
    return userRepository.get(username);
  }

  public AppUser getUser(final String username, final String password) {
    final AppUser appUser = userRepository.get(username);
    if (passwordEncoder.matches(password, appUser.getPassword())) {
      return appUser;
    }

    throw new RuntimeException("Invalid credentials!");
  }
}
