package com.example.swagger.controller;

import com.example.swagger.dto.UserDto;
import com.example.swagger.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class MainController {

  private final UserService userService;

  @GetMapping("main")
  public ModelAndView main(@RequestParam final String name) {
    UserDto userDto = userService.get(1L);
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("main");
    modelAndView.addObject("name", name);
    modelAndView.addObject("user", userDto);
    return modelAndView;
  }

}
