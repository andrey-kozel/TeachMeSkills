package com.example.elastic.converter;

import java.util.List;

import com.example.elastic.dto.CreateUserDto;
import com.example.elastic.dto.UserDto;
import com.example.elastic.model.AppUser;
import org.mapstruct.Mapper;

@Mapper
public interface UserConverter {

  AppUser fromDto(final CreateUserDto source);

  UserDto toDto(final AppUser source);

  List<UserDto> toDto(final List<AppUser> source);

}
