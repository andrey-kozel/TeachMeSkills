package com.example.lesson27.model;

import com.example.lesson27.container.ContainerManager;
import com.example.lesson27.container.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContainerManagerTest {

  @Test
  public void shouldLeftLessThanLargeContainerSizeInRemainigCapacity() {
    final ContainerManager containerManager = new ContainerManager(36);

    final Result result = containerManager.distributeContainers();

    Assertions.assertEquals(result.getCountOfLargeContainers(), 7);
  }

  @Test
  public void allNotConsumedSpaceShouldBeAddedToRemainingCount() {
    final ContainerManager containerManager = new ContainerManager(39);

    final Result result = containerManager.distributeContainers();

    Assertions.assertEquals(result.getRemainingCapacity(), 1);
  }

  @Test
  public void shouldLeftLessThanSmallContainerSizeInRemainigCapacity() {
    final ContainerManager containerManager = new ContainerManager(39);

    final Result result = containerManager.distributeContainers();

    Assertions.assertEquals(result.getCountOfSmallContainers(), 1);
  }

}
