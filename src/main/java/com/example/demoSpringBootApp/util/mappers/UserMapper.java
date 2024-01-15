package com.example.demoSpringBootApp.util.mappers;

import com.example.demoSpringBootApp.domain.User;
import com.example.demoSpringBootApp.dto.UserDto;
import com.example.demoSpringBootApp.dto.UserReadDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserDto userDto);

    UserReadDto toUserReadDto(User user);

    List<UserReadDto> toListUserReadDto(List<User> users);
}
