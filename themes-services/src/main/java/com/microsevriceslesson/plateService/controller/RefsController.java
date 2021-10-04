package com.microsevriceslesson.plateService.controller;

import com.microsevriceslesson.plateService.entity.References;
import com.microsevriceslesson.plateService.service.RefsServiceImpl;
import com.microsevriceslesson.plateService.service.interfaces.RefsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/refs")
@Slf4j
@RequiredArgsConstructor
public class RefsController {

    private final RefsService refsService;

    @PostMapping("/")
    @ApiOperation(value = "Сохрнение или редактирование ссылки")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Error")
    })
    public References saveOrUpdateReference(@RequestBody References references) {
        log.info("INSIDE savePlate method" + references.toString());
        return refsService.saveOrUpdate(references);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Получение ссылки по ИД")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Error")
    })
    public References findReferenceByID(@ApiParam(value = "ID ссылки") @PathVariable("id") Long refId) {
        log.info("INSIDE findPlateByID method - plateID: " + refId);
        return refsService.findByRefId(refId);
    }

    @GetMapping("/all_refs")
    @ApiOperation(value = "Получение всех ссылок плиты")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Error")
    })
    public List<References> findByPlatePlateId(@ApiParam(value = "ID плиты", required = true) @RequestParam Long plateId) {
        log.info("INSIDE findByTagName method - plateID: " + plateId);
        return refsService.findByPlatePlateId(plateId);
    }
}
