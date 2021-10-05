package com.microsevriceslesson.plateService.controller;

import com.microsevriceslesson.plateService.controller.dto.ReferenceDto;
import com.microsevriceslesson.plateService.entity.Reference;
import com.microsevriceslesson.plateService.mapper.ReferenceMapper;
import com.microsevriceslesson.plateService.service.interfaces.ReferenceService;
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
@RequestMapping("/refs")
@Slf4j
@RequiredArgsConstructor
public class ReferenceController {

    private final ReferenceService referenceService;
    private final ReferenceMapper referenceMapper;

    @PostMapping("/")
    @ApiOperation(value = "Create reference")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Error")
    })
    public ResponseEntity<ReferenceDto> createReference(@RequestBody Reference reference) {
        log.info("INSIDE savePlate method" + reference.toString());
        Reference createdReference = referenceService.saveOrUpdate(reference);
        return ResponseEntity.ok(referenceMapper.toDto(createdReference));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get reference by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Error")
    })
    public ResponseEntity<ReferenceDto> getReferenceById(@ApiParam(value = "Reference id")
                                      @PathVariable("id") Long refId) {
        log.info("INSIDE findPlateByID method - plateID: " + refId);
        Reference reference = referenceService.findByRefId(refId);
        return ResponseEntity.ok(referenceMapper.toDto(reference));
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all references by plate id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Error")
    })
    public ResponseEntity<List<ReferenceDto>> getAllReferencesByPlateId(@ApiParam(value = "Plate id", required = true)
                                                     @RequestParam Long plateId) {
        log.info("INSIDE findByTagName method - plateID: " + plateId);
        List<Reference> referenceList = referenceService.findByPlatePlateId(plateId);
        return ResponseEntity.ok(referenceList.stream()
                .map(referenceMapper::toDto)
                .collect(Collectors.toList()));
    }
}
