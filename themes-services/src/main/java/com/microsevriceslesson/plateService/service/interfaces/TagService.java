package com.microsevriceslesson.plateService.service.interfaces;

import com.microsevriceslesson.plateService.entity.Tag;

public interface TagService {
    Tag getByName(String tagName);
    Tag saveOrUpdate(Tag tag);
}
