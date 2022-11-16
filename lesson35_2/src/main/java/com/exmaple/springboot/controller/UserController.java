package com.exmaple.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import com.exmaple.springboot.dto.CreateUserDto;
import com.exmaple.springboot.model.User;
import com.exmaple.springboot.service.UserService;
import com.exmaple.springboot.session.AuthContext;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;
  private final AuthContext authContext;

  @GetMapping
  public String getUsers(final Model model) {
    final List<User> users = userService.findUsers();
    model.addAttribute("users", users);
    model.addAttribute("dto", new CreateUserDto());
    return "users";
  }

  @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  public String createUser(
    @Valid @ModelAttribute("dto") final CreateUserDto dto,
    final BindingResult result,
    final Model model
  ) {
    if (!result.hasErrors()) {
      userService.createUser(dto.getName(), dto.getPassword(), dto.getRole());
      authContext.setAuthorized(true);
    }

    final List<User> users = userService.findUsers();
    model.addAttribute("users", users);
    return "users";
  }

}
