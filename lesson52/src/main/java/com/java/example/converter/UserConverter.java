package com.java.example.converter;

import java.util.List;

import com.java.example.dto.UserDto;
import com.java.example.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserConverter {

  List<UserDto> toDto(List<UserEntity> source);

}
