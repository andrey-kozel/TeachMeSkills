package com.example.elastic.config.elastic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.http.HttpHeaders;

@Configuration
public class ElasticsearchConfig extends ElasticsearchConfiguration {

  private final String elasticsearchUrl;

  public ElasticsearchConfig(@Value("${elastic.url}") final String elasticsearchUrl) {
    this.elasticsearchUrl = elasticsearchUrl;
  }

  @Override
  public ClientConfiguration clientConfiguration() {
    final HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("Content-type", "application/json");
    httpHeaders.add("X-Elastic-Product", "Example");
    return ClientConfiguration.builder()
      .connectedTo(elasticsearchUrl)
      .withDefaultHeaders(httpHeaders)
      .build();
  }
}
