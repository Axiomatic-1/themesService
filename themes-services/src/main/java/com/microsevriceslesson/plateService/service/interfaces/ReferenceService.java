package com.microsevriceslesson.plateService.service.interfaces;

import com.microsevriceslesson.plateService.entity.Reference;

import java.util.List;

public interface ReferenceService {
    Reference getById(Long id);
    List<Reference> getAllByPlateId(Long plateId);
    Reference saveOrUpdate(Reference reference);
}
