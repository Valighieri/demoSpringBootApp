package com.example.demoSpringBootApp.util.mappers;

import com.example.demoSpringBootApp.domain.User;
import com.example.demoSpringBootApp.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserDto userDto);
}
