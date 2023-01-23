/*
 * Copyright (C) 2021 ReserveHub. All rights reserved.
 */

package com.example.groovy.command;

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
public class SyncOrganizationCommand {

  private final UUID organizationId;
  private final String token;

}
