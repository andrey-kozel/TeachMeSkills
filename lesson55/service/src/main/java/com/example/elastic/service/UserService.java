package com.example.elastic.service;

import com.example.elastic.model.AppUser;
import com.example.elastic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public AppUser get(final String username) {
    return userRepository.get(username);
  }

  public AppUser save(final AppUser user) {
    final AppUser encryptedUser = user.toBuilder()
      .password(passwordEncoder.encode(user.getPassword()))
      .build();

    return userRepository.save(encryptedUser);
  }

  public AppUser verifyUser(final String username, final String password) {
    final AppUser appUser = userRepository.get(username);

    if (passwordEncoder.matches(appUser.getPassword(), password)) {
      return appUser;
    }

    throw new IllegalStateException("Provided wrong password for user " + username);
  }
}
