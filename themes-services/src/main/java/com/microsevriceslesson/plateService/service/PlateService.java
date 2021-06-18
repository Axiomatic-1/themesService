package com.microsevriceslesson.plateService.service;

import com.microsevriceslesson.plateService.entity.Plate;
import com.microsevriceslesson.plateService.repository.PlateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlateService {

    private PlateRepository plateRepository;

    @Autowired
    public PlateService(PlateRepository plateRepository) {
        this.plateRepository = plateRepository;
    }

    public Plate savePlate(Plate plate) {
        return plateRepository.save(plate);
    }

    public Plate plateFindById(Long departmentId) {
        return plateRepository.findByPlateId(departmentId);
    }
}
