package com.microsevriceslesson.plateService.service;

import com.microsevriceslesson.plateService.entity.User;
import com.microsevriceslesson.plateService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public User saveOrUpdate(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Long id){
        return userRepository.findByUserId(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

}