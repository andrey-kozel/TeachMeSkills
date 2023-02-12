package com.example.elastic.service;

import java.util.List;

import com.example.elastic.model.AppUser;
import com.example.elastic.repository.UserSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSearchService {

  private final UserSearchRepository userSearchRepository;

  public void indexUser(final AppUser savedUser) {
    userSearchRepository.index(savedUser);
  }

  public List<Long> findByDescription(final String description) {
    return userSearchRepository.findByDescription(description);
  }

}
