package com.exmaple.aspect.aspect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.exmaple.aspect.model.User;
import org.aspectj.lang.ProceedingJoinPoint;

public class CachingAspect {

  private final Map<Integer, User> cachedUsers = new HashMap<>();

  public Object beforeGet(final ProceedingJoinPoint jp) throws Throwable {
    final int id = Arrays.stream(jp.getArgs())
      .findFirst()
      .map(Integer.class::cast)
      .orElseThrow(() -> new IllegalStateException("Incoming parameter is not an integer"));

    if (cachedUsers.containsKey(id)) {
      System.out.println("User in the cache. Get from cache. Id " + id);
      return cachedUsers.get(id);
    }

    System.out.println("User is not in the cache. Call real method. Id " + id);
    final User user = (User) jp.proceed(jp.getArgs());

    cachedUsers.put(id, user);

    return user;
  }

}
