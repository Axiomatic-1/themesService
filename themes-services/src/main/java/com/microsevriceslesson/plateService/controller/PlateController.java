package com.microsevriceslesson.plateService.controller;

import com.microsevriceslesson.plateService.entity.Plate;
import com.microsevriceslesson.plateService.entity.References;
import com.microsevriceslesson.plateService.entity.Tags;
import com.microsevriceslesson.plateService.serviceInterfaces.PlateServiceInter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/departments")
@Slf4j
public class PlateController {

    @Autowired
    PlateServiceInter plateServiceInter;


    @PostMapping("/")
    public Plate savePlate(@RequestBody Plate plate) {
        log.info("INSIDE savePlate method" + plate.toString());
        return plateServiceInter.savePlate(plate);
    }


    @GetMapping("/example")
    public Plate returnPlate() {
        Set<References> ref = new HashSet<>();
        ref.add(new References("vk.com", "social_media"));
        ref.add(new References("facebook.com", "social_media2"));
        Set<Tags> tag = new HashSet<>();
        tag.add(new Tags("tag"));
        Plate plate = new Plate();
        plate.setPlateName("Vk-Plate");
        plate.setReferences(ref);
        plate.setTag(tag);
        log.info("Saving test example of Plate");
        plateServiceInter.savePlate(plate);
        log.info("saved " + plate.toString());
        return plate;
    }

    @GetMapping("/{id}")
    public Plate findPlateByID(@PathVariable("id") Long plateId) {
        log.info("INSIDE findPlateByID method - plateID: " + plateId);
        return plateServiceInter.plateFindById(plateId);
    }

}
