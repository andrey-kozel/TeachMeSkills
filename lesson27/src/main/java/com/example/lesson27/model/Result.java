package com.example.lesson27.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Result {

  int countOfSmallContainers;
  int countOfLargeContainers;
  int remainingCapacity;

}
