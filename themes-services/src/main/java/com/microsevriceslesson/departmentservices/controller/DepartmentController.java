package com.microsevriceslesson.departmentservices.controller;

import com.microsevriceslesson.departmentservices.entity.Department;
import com.microsevriceslesson.departmentservices.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private DepartmentService departmentService;
    private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("INSIDE saveDepartment method");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentByID(@PathVariable("id") Long departmentId){
        log.info("INSIDE findDepartmentByID method" + departmentId);
        return departmentService.departmentFindById(departmentId);
    }

}
