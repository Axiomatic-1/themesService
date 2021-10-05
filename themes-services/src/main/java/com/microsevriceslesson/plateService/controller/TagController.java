package com.microsevriceslesson.plateService.controller;


import com.microsevriceslesson.plateService.controller.dto.TagDto;
import com.microsevriceslesson.plateService.entity.Tag;
import com.microsevriceslesson.plateService.mapper.TagMapper;
import com.microsevriceslesson.plateService.service.interfaces.TagService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tags")
@Slf4j
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;
    private final TagMapper tagMapper;

    @PostMapping("/")
    @ApiOperation(value = "Create tag")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Error")
    })
    public ResponseEntity<TagDto> createTag(@RequestBody Tag tag) {
        log.info("INSIDE saveTag method" + tag.toString());
        Tag createdTag = tagService.saveOrUpdate(tag);
        return ResponseEntity.ok(tagMapper.toDto(createdTag));
    }

    @GetMapping("/")
    @ApiOperation(value = "Get tag by name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Error")
    })
    public ResponseEntity<TagDto> getTagByName(@ApiParam(value = "Tag anme") @RequestParam("name") String name) {
        log.info("INSIDE findTagByID method - tagId: " + name);
        Tag tag = tagService.findTagById(name);
        return ResponseEntity.ok(tagMapper.toDto(tag));
    }
}
