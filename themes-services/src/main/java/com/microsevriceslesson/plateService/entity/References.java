package com.microsevriceslesson.plateService.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "refers")
@Builder
public class References {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refId;
    @Column(length = 1500, unique = true, nullable = false)
    private String refs;
    @Column(length = 2000)
    private String comments;


    public References(String refs, String comments) {
        this.refs = refs;
        this.comments = comments;
    }

    @ManyToOne(targetEntity = Plate.class)
    @JoinColumn(name = "plate_id")
    private Plate plate;
}
