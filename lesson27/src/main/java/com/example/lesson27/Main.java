package com.example.lesson27;

/*
  Написать менеджер контейнеров, у которого есть какое-то свободное место и возможность добавлять контейнеры
  объемом 3 и 5 единиц.
 */

import com.example.lesson27.container.ContainerManager;
import com.example.lesson27.container.Result;
import com.example.lesson27.twosums.TwoSums;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

  public static void main(String[] args) {
    final ContainerManager containerManager = new ContainerManager(21);
    final Result result = containerManager.distributeContainers();
    log.info("Result calculated. Result=[{}]", result);
    final TwoSums twoSums = new TwoSums();
    final int[] result2 = twoSums.calculate(new int[]{1, 2, 3}, 5);
    log.info("Result calculated. Result=[{}]", result2);
  }

}
