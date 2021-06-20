package com.microsevriceslesson.plateService.util;

import com.microsevriceslesson.plateService.entity.References;
import com.microsevriceslesson.plateService.entity.dto.ReferencesDto;
import com.microsevriceslesson.plateService.repository.PlateRepository;
import com.microsevriceslesson.plateService.repository.ReferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Converter implements ConverterAbstract{


    @Autowired
    private PlateRepository plateRepository;


    public References refDtoToRef(ReferencesDto referencesDto) {
        return References.builder()
                .refs(referencesDto.getRefs())
                .comments(referencesDto.getComments())
                .plate(plateRepository.findByPlateId(referencesDto.getPlateId()))
                .build();
    }

}
