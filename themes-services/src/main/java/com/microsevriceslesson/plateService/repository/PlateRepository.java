package com.microsevriceslesson.plateService.repository;

import com.microsevriceslesson.plateService.entity.Plate;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlateRepository extends JpaRepository<Plate, Long> {

    Plate findByPlateId(Long plateId);

    Plate save(Plate plate);

    @Query(value = "select p from Plate p join fetch Tags t on p.plateId=t.id where t.tagName =:tagName")
    Plate findByTagName(@Param("tagName") String tagName);
}
