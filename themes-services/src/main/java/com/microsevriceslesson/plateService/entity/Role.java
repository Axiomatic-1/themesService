package com.microsevriceslesson.plateService.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    Long id;

    @Column(name = "role_name")
    String name;

    @OneToMany(targetEntity = Plate.class, mappedBy = "user", fetch = FetchType.LAZY)
    Set<User> users;

}
