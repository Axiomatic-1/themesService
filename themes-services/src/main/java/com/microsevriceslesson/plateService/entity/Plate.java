package com.microsevriceslesson.plateService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "departments")
public class Plate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long plateId;
    @Column(name = "department_name")
    private String plateName;
    @Column(name = "adress")
    private String adress;
    @Column(name = "department_code")
    private String departmentCode;

}
