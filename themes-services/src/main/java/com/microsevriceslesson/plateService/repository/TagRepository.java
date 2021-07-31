package com.microsevriceslesson.plateService.repository;

import com.microsevriceslesson.plateService.entity.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TagRepository extends JpaRepository<Tags, Long> {

    Tags findByTagName(String name);


}

