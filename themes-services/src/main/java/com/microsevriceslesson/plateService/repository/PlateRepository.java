package com.microsevriceslesson.plateService.repository;

import com.microsevriceslesson.plateService.entity.Plate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlateRepository extends JpaRepository<Plate, Long> {

    Plate findByPlateId(Long plateId);

    Plate save(Plate plate);

}
