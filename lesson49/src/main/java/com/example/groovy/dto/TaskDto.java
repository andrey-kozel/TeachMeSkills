/*
 * Copyright (C) 2021 ReserveHub. All rights reserved.
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
public class TaskDto {

  private final UUID id;
  private final UUID organizationId;
  private final TaskType type;
  private final TaskStatus status;
  private final Instant createdAt;
  private final Instant updatedAt;

}
