package com.microsevriceslesson.plateService.service;

import com.microsevriceslesson.plateService.entity.Plate;
import com.microsevriceslesson.plateService.entity.References;
import com.microsevriceslesson.plateService.repository.RefsRepository;
import liquibase.change.core.CreateTableChange;
import org.springframework.stereotype.Service;

import java.sql.Ref;
import java.util.List;

@Service
public class RefsService {

    private final RefsRepository refsRepository;

    public RefsService(RefsRepository refsRepository) {
        this.refsRepository = refsRepository;
    }

    public References findByRefId(Long id){
        return refsRepository.findByRefId(id);
    }

    public List<References> findByPlatePlateId(Long plateId){
        return refsRepository.findByPlatePlateId(plateId);
    }

    public References saveOrUpdate(References references) {
        return refsRepository.save(references);
    }
}
