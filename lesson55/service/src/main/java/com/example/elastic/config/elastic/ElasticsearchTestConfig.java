package com.example.elastic.config.elastic;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

import javax.annotation.PostConstruct;

import com.example.elastic.facade.UserFacade;
import com.example.elastic.model.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ElasticsearchTestConfig {

  private final UserFacade userFacade;

  @PostConstruct
  public void init() {
    LongStream.range(1, 200)
        .mapToObj(i -> AppUser.builder()
          .username("user" + i)
          .password("password" + i)
          .description("my awesome user" + i)
          .build())
      .forEach(userFacade::save);
  }

}
