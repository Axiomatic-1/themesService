package com.microsevriceslesson.plateService.repository;

import com.microsevriceslesson.plateService.entity.References;
import com.microsevriceslesson.plateService.entity.dto.ReferencesDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReferencesRepository extends JpaRepository<References, Long> {

    References saveReferences(References references);

    References findByRefId(Long id);

}
