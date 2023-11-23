package com.dailycode.springtutorial.controller;

import com.dailycode.springtutorial.model.Department;
import com.dailycode.springtutorial.model.SecondDepartment;
import com.dailycode.springtutorial.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {
    
    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService, SecondDepartment secondDepartment) {
        this.departmentService = departmentService;
    }
    
    @PostMapping("/department")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/department")
    public List<Department> getAllDepartment() {
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
