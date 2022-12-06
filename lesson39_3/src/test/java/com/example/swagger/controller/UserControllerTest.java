package com.example.swagger.controller;

import com.example.swagger.dto.UpdateUserDto;
import com.example.swagger.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

  private static final ObjectMapper MAPPER = new ObjectMapper();

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserService userService;

  @Test
  public void shuoldReturnUserById() throws Exception {
    final Long userId = 1L;
    mockMvc.perform(MockMvcRequestBuilders
        .get("/api/v1/users/{userId}", userId)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andReturn();

    then(userService)
      .should()
      .get(1L);
  }

  @Test
  public void shouldReturnBadRequestWhenUserIdIsInvalid() throws Exception {
    final String userId = "invalidate";
    mockMvc.perform(MockMvcRequestBuilders
        .get("/api/v1/users/{userId}", userId)
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isBadRequest());

    then(userService)
      .shouldHaveNoInteractions();
  }

  @Test
  public void shouldReturn200WhenUserIsValid() throws Exception {
    final Long userId = 1L;
    final UpdateUserDto dto = UpdateUserDto.builder()
      .firstName("first")
      .lastName("last")
      .password("password123")
      .build();
    mockMvc.perform(MockMvcRequestBuilders
        .put("/api/v1/users/{userId}", userId)
        .contentType(MediaType.APPLICATION_JSON)
        .content(MAPPER.writeValueAsString(dto))
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isAccepted());

    then(userService)
      .shouldHaveNoInteractions();
  }

  @ParameterizedTest
  @CsvSource(value = {
    "invalid! {\"firstName\": \"12\", \"lastName\": \"14\", \"password\": \"12345678\"}! reason",
    "1! {\"lastName\": \"14\", \"password\": \"12345678\"}! reason",
    "1! {\"firstName\": \"12\", \"password\": \"12345678\"}! reason",
    "1! {\"firstName\": \"12\", \"lastName\": \"14\"}! reason",
    "1! {\"firstName\": \"1\", \"lastName\": \"14\", \"password\": \"12345678\"}! reason",
    "1! {\"firstName\": \"12\", \"lastName\": \"1\", \"password\": \"12345678\"}! reason",
    "1! {\"firstName\": \"12\", \"lastName\": \"14\", \"password\": \"1234\"}! reason"
  }, delimiter = '!')
  public void shouldReturn400WhenUpdatedUserWithInvalidDto(final String userId, final String content, final String reason) throws Exception {
    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
        .put("/api/v1/users/{userId}", userId)
        .contentType(MediaType.APPLICATION_JSON)
        .content(content)
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isBadRequest())
      .andExpect(content().string(reason))
      .andReturn();

    then(userService)
      .shouldHaveNoInteractions();
  }

}
