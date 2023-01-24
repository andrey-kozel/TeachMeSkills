package com.example.groovy.facade

import com.example.groovy.client.TaskClient
import com.example.groovy.command.SyncOrganizationCommand
import com.example.groovy.dto.ConnectorType
import com.example.groovy.dto.RepositoryStatsDto
import com.example.groovy.dto.TaskDto
import com.example.groovy.dto.TaskStatus
import com.example.groovy.dto.TaskType
import com.example.groovy.service.StatsPublishService
import com.example.groovy.service.SyncOrganizationService
import spock.lang.Specification

class SyncOrganizationFacadeTest extends Specification {

    private static final Integer DEFAULT_PAGE_SIZE = 30
    private static final Integer LESS_THAN_PAGE_SIZE = 15
    private static final String ANY_TOKEN = "any_token"
    private static final String TOKEN = "token"
    private static final UUID ANY_UUID = UUID.fromString("125e4567-e89b-12d3-a456-426614174000")
    private static final UUID ORGANIZATION_UUID = UUID.fromString("123e4567-e89b-12d3-a456-426614174000")
    private static final UUID TASK_UUID = UUID.fromString("123e4569-e89b-12d3-a456-426614174000")
    private static final RepositoryStatsDto ANY_REPOSITORY = RepositoryStatsDto.builder().build();
    private static final SyncOrganizationCommand ANY_COMMAND = SyncOrganizationCommand.builder().build();

    private SyncOrganizationService syncOrganizationService = Mock()
    private StatsPublishService<RepositoryStatsDto> statsPublishService = Mock()
    private TaskClient taskClient = Mock()

    def sut = new SyncOrganizationFacade(syncOrganizationService, statsPublishService, taskClient)

    void setup() {
        taskClient.createTask(_, _) >> Mock(TaskDto)
    }

    def "Should create sync organization task when processing was started"() {
        given:
        final SyncOrganizationCommand command = SyncOrganizationCommand.builder()
                .organizationId(ORGANIZATION_UUID)
                .token(ANY_TOKEN)
                .build()
        final TaskDto task = TaskDto.builder()
                .id(ANY_UUID)
                .build()

        when:
        sut.syncRepos(command)

        then:
        1 * taskClient.createTask(ORGANIZATION_UUID, TaskType.SYNC_ORGANIZATION) >> task
    }

    def "Should load repository with provided organization and token using default filter values"() {
        given:
        final SyncOrganizationCommand command = SyncOrganizationCommand.builder()
                .organizationId(ORGANIZATION_UUID)
                .token(TOKEN)
                .build()
        when:
        sut.syncRepos(command)

        then:
        1 * syncOrganizationService.synchronizeRepositories(ORGANIZATION_UUID, TOKEN, {
            assert it.affiliation == "owner"
            assert it.pageSize == 30
            assert it.page == 1
        })
    }

    def "Should publish loaded repositories to the stats service"() {
        given:
        final List<RepositoryStatsDto> dtos = Collections.nCopies(LESS_THAN_PAGE_SIZE, ANY_REPOSITORY);
        syncOrganizationService.synchronizeRepositories(_, _, _) >>> [dtos]

        when:
        sut.syncRepos(ANY_COMMAND)

        then:
        1 * statsPublishService.publishMessages(ConnectorType.GITHUB_REPOSITORY_STATS, dtos)
    }

    def "Should load the second page when first page returned #{DEFAULT_PAGE_SIZE} items"() {
        given:
        final List<RepositoryStatsDto> dtos = Collections.nCopies(DEFAULT_PAGE_SIZE, ANY_REPOSITORY);
        syncOrganizationService.synchronizeRepositories(_, _, _) >>> [dtos, [ANY_REPOSITORY]]

        when:
        sut.syncRepos(ANY_COMMAND)

        then:
        1 * syncOrganizationService.synchronizeRepositories(_, _, {
            assert it.page == 2
        })
    }

    def "Should mark task as completed when all processing of repositories finished"() {
        given:
        final TaskDto task = TaskDto.builder()
                .id(TASK_UUID)
                .build()
        syncOrganizationService.synchronizeRepositories(_, _, _) >> []

        when:
        sut.syncRepos(ANY_COMMAND)

        then:
        1 * taskClient.createTask(_, _) >> task
        1 * taskClient.updateTask(TASK_UUID, TaskStatus.COMPLETED)
    }

    def "Should mark task as failed when error was thrown during repositories processing"() {
        given:
        final TaskDto task = TaskDto.builder()
                .id(TASK_UUID)
                .build()
        syncOrganizationService.synchronizeRepositories(_, _, _) >> { throw new RuntimeException("Sync failed") }

        when:
        sut.syncRepos(ANY_COMMAND)

        then:
        1 * taskClient.createTask(_, _) >> task
        1 * taskClient.updateTask(TASK_UUID, TaskStatus.FAILED)
    }

}
