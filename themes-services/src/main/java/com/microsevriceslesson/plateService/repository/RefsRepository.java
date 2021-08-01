package com.microsevriceslesson.plateService.repository;

import com.microsevriceslesson.plateService.entity.References;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RefsRepository extends JpaRepository<References, Long> {

    References findByRefId(Long refId);

    List<References> findByPlatePlateId(Long id);
}
