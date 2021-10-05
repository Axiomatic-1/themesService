package com.microsevriceslesson.plateService.service.interfaces;

import com.microsevriceslesson.plateService.entity.Plate;

import java.util.List;

public interface PlateService {
    Plate getById(Long plateId);
    Plate saveOrUpdate(Plate plate);
    Plate getByTagName(String name);
    List<Plate> getAllUserPlatesByUserId(Long id);
}
