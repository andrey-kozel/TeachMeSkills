package com.example.mvc.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.mvc.dto.CreateUserDto;
import com.example.mvc.model.User;
import com.example.mvc.service.UserService;
import com.example.mvc.session.AuthContext;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Validated
@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;
  private final AuthContext authContext;

  @GetMapping
  public String getUsers(final ModelMap model) {
    final List<User> users = userService.findUsers();
    model.addAttribute("users", users);
    return "users";
  }

  @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  public RedirectView createUser(@Valid final CreateUserDto dto) {
    userService.createUser(dto.getName(), dto.getPassword(), dto.getRole());
    authContext.setAuthorized(true);
    return new RedirectView("users");
  }

}
