package com.microsevriceslesson.plateService.mapper;

import com.microsevriceslesson.plateService.controller.dto.UserDto;
import com.microsevriceslesson.plateService.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User fromDto(UserDto userDto);
    UserDto toDto(User user);
}
