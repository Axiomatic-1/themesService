package com.microsevriceslesson.plateService.service;

import com.microsevriceslesson.plateService.entity.User;

import java.util.List;

public interface UserService {

    User saveOrUpdate(User user);

    User findUserById(Long id);

    User findByEmail(String email);

    List<User> findAllUsers();
}
