package com.microsevriceslesson.plateService.controller;

import com.microsevriceslesson.plateService.entity.Plate;
import com.microsevriceslesson.plateService.service.PlateServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plates")
@Slf4j
@RequiredArgsConstructor
public class PlateController {

     private final PlateServiceImpl plateService;

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

    @GetMapping("/all_plates")
    @ApiOperation(value = "Получение всех плит юзера")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Error")
    })
    public List<Plate> getAllUserPlates(@ApiParam(value = "ID юзера", required = true) @RequestParam Long userId) {
        log.info("INSIDE getAllUserPlates method - userId: " + userId);
        return plateService.getAllUserPlates(userId);
    }

}
