package com.microsevriceslesson.departmentservices.service;

import com.microsevriceslesson.departmentservices.entity.Department;
import com.microsevriceslesson.departmentservices.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department departmentFindById(Long departmentId) {
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
