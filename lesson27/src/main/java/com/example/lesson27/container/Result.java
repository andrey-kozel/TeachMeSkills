package com.example.lesson27.container;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Builder
@AllArgsConstructor
@Value
public class Result {

  int countOfSmallContainers;
  int countOfLargeContainers;
  int remainingCapacity;

}
