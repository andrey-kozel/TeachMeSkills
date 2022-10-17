package com.example.lesson27.prettysize;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SizePrettifierTest {

  private final SizePrettifier sut = new SizePrettifier();

  @ParameterizedTest
  @CsvSource({
    "1,1B",
    "10000,10Kb",
    "10000000,10Mb",
    "10000000000,9Gb"
  })
  public void shouldConvertCorrectly(long value, String desiredResult) {
    String prettify = sut.prettify(value);

    Assertions.assertEquals(prettify, desiredResult);
  }

}
