package com.example.swagger.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiParam;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@Value
public class FriendDto {

  @ApiParam(example = "1", required = true)
  @NotNull
  Long requestId;

  @ApiParam(example = "2", required = true)
  @NotNull
  Long userId;

  @ApiParam(example = "3", required = true)
  @NotNull
  Long friendId;

}
