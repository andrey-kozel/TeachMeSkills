package com.exmaple.aspect.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Builder
public class User {

  private final int id;
  private final String name;

}
