package com.microsevriceslesson.plateService.serviceInterfaces;

import com.microsevriceslesson.plateService.entity.Plate;
import org.springframework.stereotype.Service;

@Service
public interface PlateServiceInter {
    Plate savePlate(Plate plate);
    Plate plateFindById(Long departmentId);
}
