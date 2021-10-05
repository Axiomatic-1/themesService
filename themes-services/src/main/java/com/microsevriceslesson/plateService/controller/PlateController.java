package com.microsevriceslesson.plateService.controller;

import com.microsevriceslesson.plateService.controller.dto.PlateDto;
import com.microsevriceslesson.plateService.entity.Plate;
import com.microsevriceslesson.plateService.mapper.PlateMapper;
import com.microsevriceslesson.plateService.service.PlateServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plates")
@Slf4j
@RequiredArgsConstructor
public class PlateController {

    private final PlateServiceImpl plateService;
    private final PlateMapper plateMapper;

    @PostMapping("/")
    @ApiOperation(value = "Create plate")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Error")
    })
    public ResponseEntity<PlateDto> createPlate(@RequestBody Plate plate) {
        log.info("INSIDE savePlate method" + plate.toString());
        Plate createdPlate = plateService.saveOrUpdate(plate);
        return ResponseEntity.ok(plateMapper.toDto(createdPlate));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get plate by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Error")
    })
    public ResponseEntity<PlateDto> getPlateById(@ApiParam(value = "Plate id")
                                                  @PathVariable("id") Long plateId) {
        log.info("INSIDE findPlateByID method - plateID: " + plateId);
        Plate plate = plateService.getById(plateId);
        return ResponseEntity.ok(plateMapper.toDto(plate));
    }

    @GetMapping("/")
    @ApiOperation(value = "Get plate by tag")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Error")
    })
    public ResponseEntity<PlateDto> getPlateByTagName(@ApiParam(value = "Tag name", required = true)
                                                  @RequestParam String tagName) {
        log.info("INSIDE findByTagName method - plateID: " + tagName);
        Plate plate = plateService.getByTagName(tagName);
        return ResponseEntity.ok(plateMapper.toDto(plate));
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all user's plates")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Error")
    })
    public ResponseEntity<List<PlateDto>> getAllPlatesByUserId(@ApiParam(value = "User id", required = true)
                                                           @RequestParam Long userId) {
        log.info("INSIDE getAllUserPlates method - userId: " + userId);
        List<Plate> plateList = plateService.getAllUserPlatesByUserId(userId);
        return ResponseEntity.ok(plateList.stream()
                .map(plateMapper::toDto)
                .collect(Collectors.toList()));
    }

}
