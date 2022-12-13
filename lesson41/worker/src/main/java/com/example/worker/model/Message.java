package com.example.worker.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Message {

  private final String content;
  private final String receipt;

}
