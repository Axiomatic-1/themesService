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
    @JoinColumn(name = "tags_in_plate_id")
    private Set<Tags> tag;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "refs_in_plate_id")
    private Set<References> references;

}
