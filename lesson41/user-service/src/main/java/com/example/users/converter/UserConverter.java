package com.example.users.converter;

import com.example.users.dto.AppUserDto;
import com.example.users.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserConverter {

  AppUserDto toDto(final User user);
}
