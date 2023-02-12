package com.example.elastic.facade;

import java.util.Collections;
import java.util.List;

import com.example.elastic.converter.UserConverter;
import com.example.elastic.dto.UserDto;
import com.example.elastic.model.AppUser;
import com.example.elastic.service.UserSearchService;
import com.example.elastic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFacade {

  private final UserService userService;
  private final UserSearchService userSearchService;
  private final UserConverter userConverter;

  public AppUser save(final AppUser user) {
    final AppUser savedUser = userService.save(user);
    userSearchService.indexUser(savedUser);
    return savedUser;
  }

  public List<UserDto> findUsers(final String description) {
    final List<Long> ids = userSearchService.findByDescription(description);

    if (ids.isEmpty()) {
      return Collections.emptyList();
    }

    final List<AppUser> users = userService.findUserByIds(ids);
    return userConverter.toDto(users);
  }

  public AppUser verifyUser(final String username, final String password) {
    return userService.verifyUser(username, password);
  }
}
