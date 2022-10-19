package com.example.lesson27.model;

import com.example.lesson27.container.ContainerManager;
import com.example.lesson27.container.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class ContainerManagerTest {

  @CsvSource({"36,7,0,1", "39,7,1,1"})
  @ParameterizedTest
  public void checkContainerManagerWorksCorrectly(
    int initialCapacity,
    int expectedLargeContainers,
    int expectedSmallContainers,
    int expectedRemainingCapacity
  ) {
    final ContainerManager containerManager = new ContainerManager(initialCapacity);

    final Result result = containerManager.distributeContainers();

    Assertions.assertEquals(result.getCountOfLargeContainers(), expectedLargeContainers);
    Assertions.assertEquals(result.getCountOfSmallContainers(), expectedSmallContainers);
    Assertions.assertEquals(result.getRemainingCapacity(), expectedRemainingCapacity);
  }

  @MethodSource("source")
  @ParameterizedTest
  public void checkContainerManagerWorksCorrectly(
    int initialCapacity,
    Result expectedResult
  ) {
    final ContainerManager containerManager = new ContainerManager(initialCapacity);

    final Result actual = containerManager.distributeContainers();

    Assertions.assertEquals(actual, expectedResult);
  }

  public static Object[][] source() {
    return new Object[][] {
      {36, new Result(0, 7, 1)}
    };
  }

}
