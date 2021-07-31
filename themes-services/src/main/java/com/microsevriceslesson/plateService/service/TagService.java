package com.microsevriceslesson.plateService.service;

import com.microsevriceslesson.plateService.entity.Tags;
import com.microsevriceslesson.plateService.repository.TagRepository;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tags findTagById(String tagName){
        return tagRepository.findByTagName(tagName);
    }

    public Tags saveOrUpdate(Tags tags){
        return tagRepository.save(tags);
    }
}
