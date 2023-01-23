/*
 * Copyright (C) 2021 ReserveHub. All rights reserved.
 */

package com.example.groovy.client;

import java.util.UUID;

import com.example.groovy.dto.TaskDto;
import com.example.groovy.dto.TaskStatus;
import com.example.groovy.dto.TaskType;

public interface TaskClient {

  TaskDto createTask(
    final UUID organizationId,
    final TaskType type
  );

  void updateTask(
    final UUID taskId,
    final TaskStatus status
  );
}
