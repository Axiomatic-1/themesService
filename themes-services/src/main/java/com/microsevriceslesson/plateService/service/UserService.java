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
    private RestTemplate restTemplate;

    @Autowired
    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithPlate(Long userId) {
        log.info("WE ARE IN GET USER WITH DEPARTMENT SERVICE!!!");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        PlateVO plate =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getPlateId()
                        , PlateVO.class);
        vo.setUser(user);
        vo.setPlate(plate);
        return vo;
    }
}