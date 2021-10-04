package com.microsevriceslesson.plateService.service;

import com.microsevriceslesson.plateService.entity.Plate;
import com.microsevriceslesson.plateService.entity.References;
import com.microsevriceslesson.plateService.repository.RefsRepository;
import com.microsevriceslesson.plateService.service.interfaces.RefsService;
import liquibase.change.core.CreateTableChange;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Ref;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RefsServiceImpl implements RefsService {

    private final RefsRepository refsRepository;

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @Transactional
    @Override
    public References findByRefId(Long id){
        return refsRepository.findByRefId(id);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @Transactional
    @Override
    public List<References> findByPlatePlateId(Long plateId){
        return refsRepository.findByPlatePlateId(plateId);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @Transactional
    @Override
    public References saveOrUpdate(References references) {
        return refsRepository.save(references);
    }
}
