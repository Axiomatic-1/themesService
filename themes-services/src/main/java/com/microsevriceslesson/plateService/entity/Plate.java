package com.microsevriceslesson.plateService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "plates")
public class Plate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plate_id")
    private Long plateId;

    @Column(name = "plate_name")
    private String plateName;

    @OneToMany(mappedBy = "plate",orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Tag> tag;

    @OneToMany(mappedBy = "plate", orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Reference> references;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

}
