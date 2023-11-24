package com.dailycode.springtutorial.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dailycode.springtutorial.model.Department;
import com.dailycode.springtutorial.model.SecondDepartment;
import com.dailycode.springtutorial.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {
    
    private final DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    
    @PostMapping("/department")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("THIS IS SAVEDEPARTMENT FROM DEPARTMENTCONTROLLER");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/department")
    public List<Department> getAllDepartment() {
        LOGGER.info("THIS IS GETALLDEPARTMENT FROM DEPARTMENTCONTROLLER");
        return departmentService.getAllDepartment();
    }

    @GetMapping("/department/{id}")
    public Optional<Department> getDepartmentById(@PathVariable("id") Long departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Successfully Deleted";
    }

    @PutMapping("/department/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId,
                                           @RequestBody Department department) {
        return departmentService.updateDepartmentById(departmentId, department);
    }

    @GetMapping("/department/name/{name}")
    public Department getDepartmentByDepartmentName(@PathVariable("name") String departmentName) {

        return departmentService.getDepartmentByDepartmentName(departmentName);
    }
}
