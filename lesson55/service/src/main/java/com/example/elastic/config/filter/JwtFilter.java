package com.example.elastic.config.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.example.elastic.config.jwt.Jwt;
import com.example.elastic.config.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component
@RequiredArgsConstructor
public class JwtFilter extends GenericFilterBean {

  public static final String AUTHORIZATION = "Authorization";

  private final Jwt jwtProvider;
  private final AuthService customUserDetailsService;

  @Override
  public void doFilter(
    ServletRequest servletRequest,
    ServletResponse servletResponse,
    FilterChain filterChain
  ) throws IOException, ServletException {
    String token = getTokenFromRequest((HttpServletRequest) servletRequest);
    if (token != null && jwtProvider.validateToken(token)) {
      String userLogin = jwtProvider.getLoginFromToken(token);
      UserDetails customUserDetails = customUserDetailsService.loadUserByUsername(userLogin);
      UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
        customUserDetails, null, customUserDetails.getAuthorities());
      SecurityContextHolder.getContext().setAuthentication(auth);
    }
    filterChain.doFilter(servletRequest, servletResponse);
  }

  private String getTokenFromRequest(HttpServletRequest request) {
    String bearer = request.getHeader(AUTHORIZATION);
    if (bearer != null && bearer.startsWith("Bearer ")) {
      return bearer.substring(7);
    }
    return null;
  }
}
