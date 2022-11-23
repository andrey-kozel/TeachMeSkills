package com.exmaple.springboot.converter;

import java.util.List;

import com.exmaple.springboot.dto.UserDto;
import com.exmaple.springboot.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserConverter {

  UserDto toDto(User source);

  List<UserDto> toDto(List<User> source);

}
