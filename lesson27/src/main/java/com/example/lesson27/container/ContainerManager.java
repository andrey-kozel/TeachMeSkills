package com.example.lesson27.container;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;

@Value
@Slf4j
public class ContainerManager {

  private static final int LARGE_CONTAINER_SIZE = 5;
  private static final int SMALL_CONTAINER_SIZE = 3;

  int capacity;

  public Result distributeContainers() {
    int remainingCapacity = capacity;
    int smallContainers = 0;
    int largeContainers = 0;
    while (remainingCapacity > LARGE_CONTAINER_SIZE) {
      remainingCapacity -= LARGE_CONTAINER_SIZE;
      largeContainers++;
    }

    log.info("Large container count calculated. LargeContainers=[{}]", largeContainers);

    while (remainingCapacity > SMALL_CONTAINER_SIZE) {
      remainingCapacity -= SMALL_CONTAINER_SIZE;
      smallContainers++;
    }

    log.info("Small container count calculated. SmallContainers=[{}]", smallContainers);

    return Result.builder()
      .remainingCapacity(remainingCapacity)
      .countOfLargeContainers(largeContainers)
      .countOfSmallContainers(smallContainers)
      .build();
  }

}
