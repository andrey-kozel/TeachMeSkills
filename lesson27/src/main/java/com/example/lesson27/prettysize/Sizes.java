package com.example.lesson27.prettysize;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Sizes {

  BYTES("B", 1),
  KILOBYTES("Kb", 1 / 1024d),
  MEGABYTES("Mb", 1 / 1024d / 1024d),
  GIGABYTES("Gb", 1 / 1024d / 1024d / 1024d),
  TERABYTES("Tb", 1 / 1024d / 1024d / 1024d / 1024d),
  PETABYTES("Pb", 1 / 1024d / 1024d / 1024d / 1024d);

  private final String shortName;
  private final double multiplier;

}
