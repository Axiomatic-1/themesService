package com.microsevriceslesson.plateService.service.interfaces;

import com.microsevriceslesson.plateService.entity.Reference;

import java.util.List;

public interface RefsService {
    Reference findByRefId(Long id);
    List<Reference> findByPlatePlateId(Long plateId);
    Reference saveOrUpdate(Reference reference);
}
