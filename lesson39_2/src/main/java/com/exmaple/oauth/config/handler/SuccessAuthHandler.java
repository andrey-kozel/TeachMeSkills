package com.exmaple.oauth.config.handler;

import java.io.IOException;
import java.time.Duration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exmaple.oauth.config.jwt.JwtProvider;
import com.exmaple.oauth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SuccessAuthHandler extends SimpleUrlAuthenticationSuccessHandler {

  private static final String TOKEN_NAME = "JWT";
  private static final String redirectUrl = "/api/v1/users";
  private static final long expiration = Duration.ofHours(3).toSeconds();

  private final JwtProvider tokenProvider;
  private final UserService userService;

  @Override
  public void onAuthenticationSuccess(
    final HttpServletRequest request,
    final HttpServletResponse response,
    final Authentication authentication
  ) throws IOException {
    final String token = tokenProvider.generateToken(authentication);
    userService.save(authentication.getName());
    clearAuthenticationAttributes(request);
    final Cookie cookie = new Cookie(TOKEN_NAME, token);
    cookie.setPath("/");
    cookie.setHttpOnly(true);
    cookie.setMaxAge((int) expiration);
    response.addCookie(cookie);

    getRedirectStrategy().sendRedirect(request, response, redirectUrl);
  }
}
