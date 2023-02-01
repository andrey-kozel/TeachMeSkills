package com.java.example.service;

import java.util.List;

import com.java.example.entity.UserEntity;
import com.java.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public List<UserEntity> getOffsetUsers(final long page, final int pageSize) {
    final PageRequest request = PageRequest.of((int) page, pageSize);
    return userRepository.getOffsetUsers(request).getContent();
  }

  public List<UserEntity> getFilteredUsers(final long idOffset, final int pageSize) {
    return userRepository.getFilteredUsers(idOffset, pageSize);
  }

}
