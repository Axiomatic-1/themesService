package com.microsevriceslesson.plateService.repository;

import com.microsevriceslesson.plateService.entity.Plate;
import com.microsevriceslesson.plateService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(Long userId);



}
