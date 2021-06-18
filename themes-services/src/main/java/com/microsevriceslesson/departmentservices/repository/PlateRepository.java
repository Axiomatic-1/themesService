package com.microsevriceslesson.departmentservices.repository;

import com.microsevriceslesson.departmentservices.entity.Plate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlateRepository extends JpaRepository<Plate, Long> {

    Plate findByPlateId(Long departmentId);

}
