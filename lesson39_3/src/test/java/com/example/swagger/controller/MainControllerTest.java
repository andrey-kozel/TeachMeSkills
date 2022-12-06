package com.example.swagger.controller;

import com.example.swagger.dto.UserDto;
import com.example.swagger.service.UserService;
import org.hamcrest.core.StringContains;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MainController.class)
class MainControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserService userService;

  @Test
  public void testMainPage() throws Exception {
    final String name = "name";
    final UserDto user = UserDto.builder()
      .firstName("first")
      .lastName("last")
      .build();
    BDDMockito.given(userService.get(1L)).willReturn(user);

    mockMvc.perform(MockMvcRequestBuilders
        .get("/main")
        .param("name", name))
      .andExpect(status().isOk())
      .andExpect(content().string(StringContains.containsString("Hello <span>name</span>")))
      .andExpect(content().string(StringContains.containsString("Firstname <span>first</span>")))
      .andExpect(content().string(StringContains.containsString("Lastname <span>last</span>")));
  }

}
