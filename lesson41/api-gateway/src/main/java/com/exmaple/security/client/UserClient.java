package com.exmaple.security.client;

import com.exmaple.security.client.dto.CreateUserDto;
import com.exmaple.security.client.dto.VerifyUserDto;
import com.exmaple.security.model.AppUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "domain", url = "${services.user.url}/api/v1/users")
public interface UserClient {

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  AppUser getUser(@PathVariable(name = "id") final String id);

  @RequestMapping(method = RequestMethod.POST, value = "/verify")
  AppUser verifyUser(final VerifyUserDto requets);

  @RequestMapping(method = RequestMethod.POST)
  AppUser saveUser(final CreateUserDto request);
}
