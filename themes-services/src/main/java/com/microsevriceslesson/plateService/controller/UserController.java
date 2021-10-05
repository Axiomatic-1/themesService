package com.microsevriceslesson.plateService.controller;


import com.microsevriceslesson.plateService.controller.dto.UserDto;
import com.microsevriceslesson.plateService.entity.User;
import com.microsevriceslesson.plateService.mapper.UserMapper;
import com.microsevriceslesson.plateService.service.interfaces.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;


    @GetMapping("/{id}")
    @ApiOperation(value = "Get user by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Error")
    })
    public ResponseEntity<UserDto> getUserById(@ApiParam(value = "ID плиты") @PathVariable("id") Long userId){
        User user = userService.getById(userId);
        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @GetMapping("/")
    @ApiOperation(value = "Get all users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Error")
    })
    public List<UserDto> getAllUsers() {
        List<User> userList = userService.getAllUsers();
        return userList.stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

}
