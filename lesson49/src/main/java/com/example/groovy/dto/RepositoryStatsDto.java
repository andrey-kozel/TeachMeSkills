/*
 * Copyright (C) 2022 ReserveHub. All rights reserved.
 */

package com.example.groovy.dto;

import java.time.Instant;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode
@ToString
public class RepositoryStatsDto {

  private final Long id;
  private final Long size;
  private final Integer starsCount;
  private final Integer watchersCount;
  private final Integer forksCount;
  private final Integer openIssuesCount;
  private final UUID organizationId;
  private final Instant synchronizedAt;

}
