package com.microsevriceslesson.plateService.service.interfaces;

import com.microsevriceslesson.plateService.entity.Tags;

public interface TagService {
    Tags findTagById(String tagName);
    Tags saveOrUpdate(Tags tags);
}
