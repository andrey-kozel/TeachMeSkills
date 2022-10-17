package com.example.lesson27.prettysize;

public class SizePrettifier {

  public String prettify(long bytes) {
    final long normalizeCount = Math.abs(bytes);
    String result = "0B";
    for (Sizes value : Sizes.values()) {
      final double size = normalizeCount * value.getMultiplier();
      if (size >= 1 && size < 1024) {
        result = Math.round(size) + value.getShortName();
      }
    }

    return result;
  }

}
