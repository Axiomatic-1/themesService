package com.microsevriceslesson.plateService.util;

import com.microsevriceslesson.plateService.entity.References;
import com.microsevriceslesson.plateService.entity.dto.ReferencesDto;
import org.springframework.stereotype.Component;

@Component
public interface ConverterAbstract {
    References refDtoToRef(ReferencesDto referencesDto);
}
