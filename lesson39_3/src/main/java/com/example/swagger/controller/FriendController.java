package com.example.swagger.controller;

import com.example.swagger.dto.FriendDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/v1/friends")
@Api("/api/v1/friends")
public class FriendController {

  @GetMapping("/{requestId}")
  @ApiOperation(value = "Get friend request by Id.")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Friend request retrieved successfully."),
    @ApiResponse(code = 404, message = "Friend request not found."),
  })
  public FriendDto get(@PathVariable final Long requestId) {
    log.info("Get friend request. Id=[{}]", requestId);
    return FriendDto.builder()
      .requestId(requestId)
      .userId(1L)
      .friendId(2L)
      .build();
  }

  @PostMapping
  @ApiOperation(value = "Create friend request.")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Friend request created successfully."),
    @ApiResponse(code = 500, message = "Friend request wasn't created."),
  })
  public void create(@RequestBody final FriendDto dto) {
    log.info("Create friend request. Dto=[{}]", dto);
  }

}
