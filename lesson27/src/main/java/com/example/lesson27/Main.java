package com.example.lesson27;

/*
  Написать менеджер контейнеров, у которого есть какое-то свободное место и возможность добавлять контейнеры
  объемом 3 и 5 единиц.
 */

import com.example.lesson27.model.ContainerManager;
import com.example.lesson27.model.Result;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

  public static void main(String[] args) {
    final ContainerManager containerManager = new ContainerManager(21);
    Result result = containerManager.distributeContainers();
    log.info("Result calculated. Result=[{}]", result);
  }

}
