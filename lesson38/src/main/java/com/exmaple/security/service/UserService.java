package com.exmaple.security.service;

import com.exmaple.security.model.AppUser;
import com.exmaple.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public AppUser getUser(final Long id) {
    return userRepository.get(id);
  }

  public AppUser getUser(final String username) {
    return userRepository.get(username);
  }
}
