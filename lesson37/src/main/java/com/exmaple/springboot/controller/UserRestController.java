package com.exmaple.springboot.controller;

import java.io.InputStream;
import java.util.List;

import javax.validation.Valid;

import com.exmaple.springboot.converter.UserConverter;
import com.exmaple.springboot.dto.CreateUserDto;
import com.exmaple.springboot.dto.UserDto;
import com.exmaple.springboot.model.User;
import com.exmaple.springboot.service.UserService;
import com.exmaple.springboot.session.AuthContext;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestController {

  private final UserService userService;
  private final UserConverter userConverter;
  private final AuthContext authContext;

  @GetMapping
  public List<UserDto> getUsers() {
    final List<User> users = userService.findUsers();
    return userConverter.toDto(users);
  }

  @GetMapping("/{userId}")
  public UserDto getUsers(@PathVariable final Long userId) {
    final User user = userService.get(userId);
    return userConverter.toDto(user);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public UserDto createUser(
    @Valid @RequestBody final CreateUserDto dto
  ) {
    final User user = userService.createUser(dto.getName(), dto.getPassword(), dto.getRole());
    authContext.setAuthorized(true);
    return userConverter.toDto(user);
  }


  @PostMapping(value = "/files", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<String> uploadFile(@RequestPart("file") final MultipartFile file) {
    return ResponseEntity.ok(file.getOriginalFilename());
  }

  @GetMapping(value = "/files", produces = MediaType.TEXT_PLAIN_VALUE)
  public ResponseEntity getFile() {
    final InputStream is = getClass().getClassLoader().getResourceAsStream("text.txt");
    return ResponseEntity.ok(new InputStreamResource(is));
  }

}
