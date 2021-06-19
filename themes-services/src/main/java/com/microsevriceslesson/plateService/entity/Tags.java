package com.microsevriceslesson.plateService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "plate_tags")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tag_name")
    private String tagName;

//    @ManyToOne(targetEntity = Plate.class)
//    @JoinColumn(name = "plate_id")
//    Plate plate;
}