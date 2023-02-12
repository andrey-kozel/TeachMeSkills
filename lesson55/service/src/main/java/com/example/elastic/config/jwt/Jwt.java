package com.example.elastic.config.jwt;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Jwt {

  @Value("$(jwt.secret)")
  private String jwtSecret;

  public String generateToken(String login) {
    Date date = Date.from(LocalDate.now().plusDays(15).atStartOfDay(ZoneId.systemDefault()).toInstant());
    return Jwts.builder()
      .setSubject(login)
      .setExpiration(date)
      .signWith(SignatureAlgorithm.HS512, jwtSecret)
      .compact();
  }

  public boolean validateToken(String token) {
    try {
      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
      return true;
    } catch (ExpiredJwtException expEx) {
      log.info("Token expired");
    } catch (UnsupportedJwtException unsEx) {
      log.info("Unsupported jwt");
    } catch (MalformedJwtException mjEx) {
      log.info("Malformed jwt");
    } catch (SignatureException sEx) {
      log.info("Invalid signature");
    } catch (Exception e) {
      log.info("invalid token");
    }
    return false;
  }

  public String getLoginFromToken(String token) {
    Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
    return claims.getSubject();
  }

}
