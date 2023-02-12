package com.example.elastic.repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.example.elastic.model.AppUser;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserSearchRepository {

  private final ElasticsearchClient client;

  @SneakyThrows
  public void index(final AppUser savedUser) {
    final IndexRequest<AppUser> request = new IndexRequest.Builder<AppUser>()
      .index("users_1")
      .type("_doc")
      .id(String.valueOf(savedUser.getId()))
      .document(savedUser)
      .build();
    client.index(request);
  }

  @SneakyThrows
  public List<Long> findByDescription(final String description) {
    final SearchRequest request = new SearchRequest.Builder()
      .query(new Query.Builder()
        .match(new MatchQuery.Builder()
          .field("description")
          .query(description)
          .build())
        .build())
      .build();
    SearchResponse<AppUser> search = client.search(request, AppUser.class);
    return search.hits().hits()
      .stream()
      .map(Hit::source)
      .filter(Objects::nonNull)
      .map(AppUser::getId)
      .collect(Collectors.toList());
  }
}
