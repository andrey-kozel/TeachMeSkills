package com.example.elastic.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class TokenDto {

  String accessToken;

}
