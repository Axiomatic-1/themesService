package com.microsevriceslesson.plateService.repository;

import com.microsevriceslesson.plateService.entity.Plate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlateRepository extends JpaRepository<Plate, Long> {
    @Query("select p from Plate p where p.plateId = ?1")
    Plate findByPlateId(Long plateId);

    Plate save(Plate plate);

}
