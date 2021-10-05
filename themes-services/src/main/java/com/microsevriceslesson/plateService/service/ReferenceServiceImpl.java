package com.microsevriceslesson.plateService.service;

import com.microsevriceslesson.plateService.entity.Reference;
import com.microsevriceslesson.plateService.repository.ReferenceRepository;
import com.microsevriceslesson.plateService.service.interfaces.ReferenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReferenceServiceImpl implements ReferenceService {

    private final ReferenceRepository referenceRepository;

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @Transactional
    @Override
    public Reference getById(Long id){
        return referenceRepository.findByRefId(id);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @Transactional
    @Override
    public List<Reference> getByPlateId(Long plateId){
        return referenceRepository.findByPlatePlateId(plateId);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @Transactional
    @Override
    public Reference saveOrUpdate(Reference reference) {
        return referenceRepository.save(reference);
    }
}
