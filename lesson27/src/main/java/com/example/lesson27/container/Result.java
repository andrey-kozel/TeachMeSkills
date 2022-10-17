package com.example.lesson27.container;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Result {

  int countOfSmallContainers;
  int countOfLargeContainers;
  int remainingCapacity;

}
