package com.exmaple.test.controller;

import com.exmaple.test.dto.UpdateUserDto;
import com.exmaple.test.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.then;
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
  public void shouldGetUserFromUserService() throws Exception {
    final Long userId = 1L;

    mockMvc.perform(MockMvcRequestBuilders
        .get("/api/v1/users/{userId}", userId)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk());

    then(userService)
      .should()
      .get(userId);
  }

  @Test
  public void shouldReturnBadRequestWhenIdInvalid() throws Exception {
    final String userId = "invalid";

    mockMvc.perform(MockMvcRequestBuilders
        .get("/api/v1/users/{userId}", userId)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isBadRequest());

    then(userService).shouldHaveNoInteractions();
  }

  @Test
  public void shouldSaveUserWhenAllParamsAreValid() throws Exception {
    final UpdateUserDto dto = UpdateUserDto.builder()
      .firstName("Name")
      .lastName("LAst")
      .password("PassPass")
      .build();

    mockMvc.perform(MockMvcRequestBuilders
        .post("/api/v1/users")
        .contentType(MediaType.APPLICATION_JSON)
        .content(MAPPER.writeValueAsString(dto))
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isAccepted());

    then(userService)
      .should()
      .save(dto);
  }

  @ValueSource(strings = {
    "{\"firstName\": \"N\", \"lastName\": \"Last\", \"password\": \"Password123\"}",
    "{\"lastName\": \"Last\", \"password\": \"Password123\"}",
    "{\"firstName\": \"Name\", \"lastName\": \"L\", \"password\": \"Password123\"}",
    "{\"firstName\": \"Name\", \"password\": \"Password123\"}",
    "{\"firstName\": \"Name\", \"lastName\": \"Last\", \"password\": \"Passw\"}",
    "{\"firstName\": \"Name\", \"lastName\": \"Last\"}"
  })
  @ParameterizedTest
  public void shouldReturn400WhenParamsAreInvalid(final String content) throws Exception {
    mockMvc.perform(MockMvcRequestBuilders
        .post("/api/v1/users")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content)
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isBadRequest());

    then(userService).shouldHaveNoInteractions();
  }

  @Test
  public void shouldUpdateUserWhenAllParamsAreValid() throws Exception {
    final Long userId = 1L;
    final UpdateUserDto dto = UpdateUserDto.builder()
      .firstName("Name")
      .lastName("LAst")
      .password("PassPass")
      .build();

    mockMvc.perform(MockMvcRequestBuilders
        .put("/api/v1/users/{userId}", userId)
        .contentType(MediaType.APPLICATION_JSON)
        .content(MAPPER.writeValueAsString(dto))
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isAccepted());

    then(userService)
      .should()
      .update(userId, dto);
  }

  @Test
  public void shouldReturn400WhenAllParamsAreValidExceptUserId() throws Exception {
    final String userId = "invalid";
    final UpdateUserDto dto = UpdateUserDto.builder()
      .firstName("Name")
      .lastName("LAst")
      .password("PassPass")
      .build();

    mockMvc.perform(MockMvcRequestBuilders
        .put("/api/v1/users/{userId}", userId)
        .contentType(MediaType.APPLICATION_JSON)
        .content(MAPPER.writeValueAsString(dto))
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isBadRequest());

    then(userService).shouldHaveNoInteractions();
  }

  @ValueSource(strings = {
    "{\"firstName\": \"N\", \"lastName\": \"Last\", \"password\": \"Password123\"}",
    "{\"lastName\": \"Last\", \"password\": \"Password123\"}",
    "{\"firstName\": \"Name\", \"lastName\": \"L\", \"password\": \"Password123\"}",
    "{\"firstName\": \"Name\", \"password\": \"Password123\"}",
    "{\"firstName\": \"Name\", \"lastName\": \"Last\", \"password\": \"Passw\"}",
    "{\"firstName\": \"Name\", \"lastName\": \"Last\"}"
  })
  @ParameterizedTest
  public void shouldReturn400WhenUpdateUserWithInvalidParams(final String content) throws Exception {
    final Long userId = 1L;

    mockMvc.perform(MockMvcRequestBuilders
        .put("/api/v1/users/{userId}", userId)
        .contentType(MediaType.APPLICATION_JSON)
        .content(content)
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isBadRequest());

    then(userService).shouldHaveNoInteractions();
  }

  @Test
  public void shouldDeleteUserWhenUserIdIsValid() throws Exception {
    final Long userId = 1L;

    mockMvc.perform(MockMvcRequestBuilders
        .delete("/api/v1/users/{userId}", userId)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isAccepted());

    then(userService)
      .should()
      .delete(userId);
  }

  @Test
  public void shouldReturn400OnDeleteWhenUserIdInvalid() throws Exception {
    final String userId = "invalid";

    mockMvc.perform(MockMvcRequestBuilders
        .delete("/api/v1/users/{userId}", userId)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isBadRequest());

    then(userService).shouldHaveNoInteractions();
  }

}
