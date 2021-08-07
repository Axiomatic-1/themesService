package com.microsevriceslesson.plateService.controller;


import com.microsevriceslesson.plateService.entity.User;
import com.microsevriceslesson.plateService.repository.UserRepository;
import com.microsevriceslesson.plateService.security.CurrentUser;
import com.microsevriceslesson.plateService.exception.ResourceNotFoundException;
import com.microsevriceslesson.plateService.security.UserPrincipal;
import com.microsevriceslesson.plateService.service.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }

    @PostMapping("/")
    @ApiOperation(value = "Сохрнение пользователя")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Error")
    })
    public User saveOrUpdateUser(@RequestBody User user){
        log.info("We are saved user :" + user.toString());
        return userServiceImpl.saveOrUpdate(user);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Поиск пользователя по ид")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Error")
    })
    public User findUserById(@ApiParam(value = "ID плиты") @PathVariable("id") Long userId){
        return userServiceImpl.findUserById(userId);
    }

    @GetMapping("/")
    @ApiOperation(value = "Получить всен юзеров")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Error")
    })
    public List<User> getAllUsers() {
        return userServiceImpl.findAllUsers();
    }


}
