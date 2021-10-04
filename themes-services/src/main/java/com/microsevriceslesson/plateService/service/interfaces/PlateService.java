package com.microsevriceslesson.plateService.service.interfaces;

import com.microsevriceslesson.plateService.entity.Plate;

import java.util.List;

public interface PlateService {
    Plate findByPlateId(Long plateId);
    Plate saveOrUpdate(Plate plate);
    Plate findByTagName(String name);
    List<Plate> getAllUserPlates(Long id);
}
