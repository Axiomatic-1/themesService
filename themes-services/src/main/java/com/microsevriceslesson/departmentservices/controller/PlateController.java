package com.microsevriceslesson.departmentservices.controller;

import com.microsevriceslesson.departmentservices.entity.Plate;
import com.microsevriceslesson.departmentservices.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class PlateController {

    private PlateService plateService;
    private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PlateController.class);
    @Autowired
    public PlateController(PlateService plateService) {
        this.plateService = plateService;
    }

    @PostMapping("/")
    public Plate savePlate(@RequestBody Plate plate) {
        log.info("INSIDE saveDepartment method");
        return plateService.savePlate(plate);
    }

    @GetMapping("/{id}")
    public Plate findPlateByID(@PathVariable("id") Long departmentId){
        log.info("INSIDE findDepartmentByID method" + departmentId);
        return plateService.plateFindById(departmentId);
    }

}
