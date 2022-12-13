package com.exmaple.security.converter;

import com.exmaple.security.client.dto.AppUserDto;
import com.exmaple.security.dto.CredentialsDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserConverter {

  AppUserDto fromDto(CredentialsDto credentials);
}
