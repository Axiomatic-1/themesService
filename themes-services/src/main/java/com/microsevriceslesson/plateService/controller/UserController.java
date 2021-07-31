package com.microsevriceslesson.plateService.controller;


import com.microsevriceslesson.plateService.VO.ResponseTemplateVO;
import com.microsevriceslesson.plateService.entity.User;
import com.microsevriceslesson.plateService.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    @ApiOperation(value = "Сохрнение пользователя")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Error")
    })
    public User saveUser(@RequestBody User user){
        log.info("We are saved user :" + user.toString());
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Поиск пользователя по ид")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Error")
    })
    public User findUserById(@ApiParam(value = "ID плиты") @PathVariable("id") Long userId){
        return userService.findUserById(userId);
    }
}
