package com.microsevriceslesson.plateService.service;

import com.microsevriceslesson.plateService.entity.Plate;
import com.microsevriceslesson.plateService.repository.PlateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PlateService {

    private final PlateRepository repository;

    public PlateService(PlateRepository repository) {
        this.repository = repository;
    }

    public Plate findByPlateId(Long plateId){
        return repository.findByPlateId(plateId);
    }

    public Plate saveOrUpdate(Plate plate){
        return repository.save(plate);
    }


    public Plate findByTagName(String name){
        return repository.findByTagName(name);
    }
}
