package com.microsevriceslesson.plateService.repository;

import com.microsevriceslesson.plateService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(Long userId);

    User findByEmail(String email);

    boolean existsByEmail(String email);

}
