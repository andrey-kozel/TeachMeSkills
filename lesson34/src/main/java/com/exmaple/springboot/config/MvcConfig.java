package com.exmaple.springboot.config;

import com.exmaple.springboot.interceptor.AuthInterceptor;
import com.exmaple.springboot.session.AuthContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.MappedInterceptor;

@Configuration
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {

  private final AuthContext authContext;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new MappedInterceptor(new String[]{"/examples"}, new AuthInterceptor(authContext)));
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/examples").setViewName("examples");
  }
}
