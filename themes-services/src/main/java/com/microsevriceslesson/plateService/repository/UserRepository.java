package com.microsevriceslesson.plateService.repository;

import com.microsevriceslesson.plateService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(Long userId);

}
