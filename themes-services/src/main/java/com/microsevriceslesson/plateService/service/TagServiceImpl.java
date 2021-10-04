package com.microsevriceslesson.plateService.service;

import com.microsevriceslesson.plateService.entity.Tags;
import com.microsevriceslesson.plateService.repository.TagRepository;
import com.microsevriceslesson.plateService.service.interfaces.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @Transactional
    @Override
    public Tags findTagById(String tagName){
        return tagRepository.findByTagName(tagName);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @Transactional
    @Override
    public Tags saveOrUpdate(Tags tags){
        return tagRepository.save(tags);
    }
}
