package com.microsevriceslesson.plateService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Table(name = "tags")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tag_name")
    private String tagName;

    public Tags(String tagName) {
        this.tagName = tagName;
    }

    @ManyToOne(targetEntity = Plate.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "plate_id")
    @JsonIgnore
    private Plate plate;
}
