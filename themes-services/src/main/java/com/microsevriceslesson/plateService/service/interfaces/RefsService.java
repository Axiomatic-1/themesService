package com.microsevriceslesson.plateService.service.interfaces;

import com.microsevriceslesson.plateService.entity.References;

import java.util.List;

public interface RefsService {
    References findByRefId(Long id);
    List<References> findByPlatePlateId(Long plateId);
    References saveOrUpdate(References references);
}
