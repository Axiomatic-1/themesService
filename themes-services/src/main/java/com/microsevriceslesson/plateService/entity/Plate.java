package com.microsevriceslesson.plateService.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "plate")
public class Plate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plate_id")
    private Long plateId;
    @Column(name = "plate_name")
    private String plateName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Tags> tag;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<References> references;

    public Plate(String plateName, Set<Tags> tag, Set<References> references) {
        this.plateName = plateName;
        this.tag = tag;
        this.references = references;
    }
}
