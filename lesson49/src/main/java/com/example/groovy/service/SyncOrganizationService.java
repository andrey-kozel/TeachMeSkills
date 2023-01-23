package com.example.groovy.service;

import java.util.List;
import java.util.UUID;

import com.example.groovy.dto.GithubRepositoryFilter;
import com.example.groovy.dto.RepositoryStatsDto;

public interface SyncOrganizationService {

  List<RepositoryStatsDto> synchronizeRepositories(
    final UUID organizationId,
    final String token,
    final GithubRepositoryFilter filter
  );

}
