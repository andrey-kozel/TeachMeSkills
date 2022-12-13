package com.exmaple.security.client;

import com.exmaple.security.client.dto.AppUserDto;
import com.exmaple.security.client.dto.CreateUserDto;
import com.exmaple.security.client.dto.VerifyResultDto;
import com.exmaple.security.client.dto.VerifyUserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "domain", url = "${services.user.url}/api/v1/users")
public interface UserClient {

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  AppUserDto getUser(@PathVariable(name = "id") final String id);

  @RequestMapping(method = RequestMethod.POST, value = "/verify")
  VerifyResultDto verifyUser(final VerifyUserDto requets);

  @RequestMapping(method = RequestMethod.POST)
  AppUserDto saveUser(final CreateUserDto request);
}
