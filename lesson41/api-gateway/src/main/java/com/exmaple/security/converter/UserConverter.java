package com.exmaple.security.converter;

import com.exmaple.security.dto.CredentialsDto;
import com.exmaple.security.dto.UserDto;
import com.exmaple.security.model.AppUser;
import org.mapstruct.Mapper;

@Mapper
public interface UserConverter {

  UserDto toDto(final AppUser user);

  AppUser fromDto(CredentialsDto credentials);
}
