package com.microsevriceslesson.plateService.controller;


import com.microsevriceslesson.plateService.entity.Tags;
import com.microsevriceslesson.plateService.service.TagService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tags")
@Slf4j
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping("/")
    @ApiOperation(value = "Сохрнение или редактирование тэга")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Error")
    })
    public Tags saveOrUpdateTag(@RequestBody Tags tags) {
        log.info("INSIDE saveTag method" + tags.toString());
        return tagService.saveOrUpdate(tags);
    }

    @GetMapping("/{name}")
    @ApiOperation(value = "Получение тэга по ИД")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Error")
    })
    public Tags findTagByName(@ApiParam(value = "Имя тэга") @PathVariable("name") String name) {
        log.info("INSIDE findTagByID method - tagId: " + name);
        return tagService.findTagById(name);
    }
}
