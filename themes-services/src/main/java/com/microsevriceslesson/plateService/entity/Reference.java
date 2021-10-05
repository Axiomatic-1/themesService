package com.microsevriceslesson.plateService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Reference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ref_id")
    private Long refId;
    @Column(length = 1500, unique = true, nullable = false)
    private String refs;
    @Column(length = 2000)
    private String comments;


    public Reference(String refs, String comments) {
        this.refs = refs;
        this.comments = comments;
    }

    @ManyToOne(targetEntity = Plate.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "plate_id")
    @JsonIgnore
    private Plate plate;
}
