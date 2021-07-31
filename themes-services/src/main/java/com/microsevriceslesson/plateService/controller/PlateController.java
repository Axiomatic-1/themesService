package com.microsevriceslesson.plateService.controller;

import com.microsevriceslesson.plateService.entity.Plate;
import com.microsevriceslesson.plateService.entity.Tags;
import com.microsevriceslesson.plateService.repository.PlateRepository;
import com.microsevriceslesson.plateService.service.PlateService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/plates")
@Slf4j
public class PlateController {

     private final PlateService plateService;

    public PlateController(PlateService plateService) {
        this.plateService = plateService;
    }

    @PostMapping("/")
    @ApiOperation(value = "Сохрнение или редактирование плиты")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Error")
    })
    public Plate saveOrUpdatePlate(@RequestBody Plate plate) {
        log.info("INSIDE savePlate method" + plate.toString());
        return plateService.saveOrUpdate(plate);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Получение плиты по ИД")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Error")
    })
    public Plate findPlateByID(@ApiParam(value = "ID плиты") @PathVariable("id") Long plateId) {
        log.info("INSIDE findPlateByID method - plateID: " + plateId);
        return plateService.findByPlateId(plateId);
    }

    @GetMapping("/")
    @ApiOperation(value = "Получение плиты по тэгу")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Error")
    })
    public Plate findByTagName(@ApiParam(value = "Имя тэга", required = true) @RequestParam String tagName) {
        log.info("INSIDE findByTagName method - plateID: " + tagName);
        return plateService.findByTagName(tagName);
    }

}
