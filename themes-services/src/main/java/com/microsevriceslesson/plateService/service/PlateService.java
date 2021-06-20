package com.microsevriceslesson.plateService.service;

import com.microsevriceslesson.plateService.entity.Plate;
import com.microsevriceslesson.plateService.repository.PlateRepository;
import com.microsevriceslesson.plateService.serviceInterfaces.PlateServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PlateService implements PlateServiceInter {

    private final PlateRepository plateRepository;


    public PlateService(PlateRepository plateRepository) {
        this.plateRepository = plateRepository;
    }

    @Override
    public Plate savePlate(Plate plate) {
        return plateRepository.save(plate);
    }

    @Override
    public Plate plateFindById(Long plateId) {
        return plateRepository.findByPlateId(plateId);
    }
}
