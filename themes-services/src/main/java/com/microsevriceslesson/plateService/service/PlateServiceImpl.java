package com.microsevriceslesson.plateService.service;

import com.microsevriceslesson.plateService.entity.Plate;
import com.microsevriceslesson.plateService.repository.PlateRepository;
import com.microsevriceslesson.plateService.service.interfaces.PlateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlateServiceImpl implements PlateService {

    private final PlateRepository repository;

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @Transactional
    @Override
    public Plate getById(Long plateId){
        return repository.findByPlateId(plateId);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @Transactional
    @Override
    public Plate saveOrUpdate(Plate plate){
        return repository.save(plate);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @Transactional
    @Override
    public Plate getByTagName(String name){
        return repository.findByTagName(name);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @Transactional
    @Override
    public List<Plate> getAllUserPlatesByUserId(Long id){return repository.getAllUserPlates(id);}
}
