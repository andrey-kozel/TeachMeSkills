/*
 * Copyright (C) 2021 ReserveHub. All rights reserved.
 */

package com.example.groovy.facade;

import java.util.List;

import com.example.groovy.client.TaskClient;
import com.example.groovy.command.SyncOrganizationCommand;
import com.example.groovy.dto.ConnectorType;
import com.example.groovy.dto.GithubRepositoryFilter;
import com.example.groovy.dto.RepositoryStatsDto;
import com.example.groovy.dto.TaskDto;
import com.example.groovy.dto.TaskStatus;
import com.example.groovy.dto.TaskType;
import com.example.groovy.service.StatsPublishService;
import com.example.groovy.service.SyncOrganizationService;

public class SyncOrganizationFacade {

  private static final int PAGE_SIZE = 30;

  private final SyncOrganizationService syncOrganizationService;
  private final StatsPublishService<RepositoryStatsDto> statsPublishService;
  private final TaskClient taskClient;

  public SyncOrganizationFacade(
    final SyncOrganizationService syncOrganizationService,
    final StatsPublishService<RepositoryStatsDto> statsPublishService,
    final TaskClient taskClient
  ) {
    this.syncOrganizationService = syncOrganizationService;
    this.statsPublishService = statsPublishService;
    this.taskClient = taskClient;
  }

  public void syncRepos(final SyncOrganizationCommand command) {
    final TaskDto task = taskClient.createTask(command.getOrganizationId(), TaskType.SYNC_ORGANIZATION);
    try {
      List<RepositoryStatsDto> dtos;
      int page = 1;
      do {
        final GithubRepositoryFilter filter = GithubRepositoryFilter.builder()
          .affiliation("owner")
          .pageSize(PAGE_SIZE)
          .page(page)
          .build();
        dtos = syncOrganizationService.synchronizeRepositories(command.getOrganizationId(), command.getToken(), filter);
        statsPublishService.publishMessages(ConnectorType.GITHUB_REPOSITORY_STATS, dtos);
        page++;
      } while (dtos.size() == PAGE_SIZE);

      taskClient.updateTask(task.getId(), TaskStatus.COMPLETED);
    } catch (Exception ex) {
      taskClient.updateTask(task.getId(), TaskStatus.FAILED);
    }
  }

}
