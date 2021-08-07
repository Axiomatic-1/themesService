package com.microsevriceslesson.plateService.service;

import com.microsevriceslesson.plateService.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveOrUpdate(User user);

    User findUserById(Long id);

    Optional<User> findByEmail(String email);

    List<User> findAllUsers();
}
