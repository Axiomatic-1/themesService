package com.microsevriceslesson.plateService.service;


import com.microsevriceslesson.plateService.VO.PlateVO;
import com.microsevriceslesson.plateService.VO.ResponseTemplateVO;
import com.microsevriceslesson.plateService.entity.User;
import com.microsevriceslesson.plateService.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }


}