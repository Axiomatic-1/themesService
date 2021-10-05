package com.microsevriceslesson.plateService.repository;

import com.microsevriceslesson.plateService.entity.Reference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RefsRepository extends JpaRepository<Reference, Long> {

    Reference findByRefId(Long refId);

    List<Reference> findByPlatePlateId(Long id);
}
