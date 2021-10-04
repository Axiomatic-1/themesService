package com.microsevriceslesson.plateService.controller;


import com.microsevriceslesson.plateService.entity.User;
import com.microsevriceslesson.plateService.service.interfaces.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
@AllArgsConstructor
public class UserController {

    private final UserService userService;

//    @PostMapping("/register")
//    @ApiOperation(value = "Регистрация пользователя")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Ok"),
//            @ApiResponse(code = 400, message = "Error")
//    })
//    public User register(@RequestBody UserDto userDto){
//        User user = userDtoMapper.fromDto(userDto);
//        log.info("We are saved user :" + user.toString());
////        return userService.registerNewUser(user);
//    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Поиск пользователя по ид")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Error")
    })
    public User findUserById(@ApiParam(value = "ID плиты") @PathVariable("id") Long userId){
        return userService.findUserById(userId);
    }

    @GetMapping("/")
    @ApiOperation(value = "Получить всен юзеров")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Error")
    })
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

}
