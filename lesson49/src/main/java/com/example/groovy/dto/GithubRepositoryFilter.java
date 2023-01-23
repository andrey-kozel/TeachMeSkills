/*
 * Copyright (C) 2021 ReserveHub. All rights reserved.
 */

package com.example.groovy.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class GithubRepositoryFilter {

  private final String affiliation;
  private final Integer pageSize;
  private final Integer page;

}
