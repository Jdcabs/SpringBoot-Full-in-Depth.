package com.dailycode.springtutorial.service;

import com.dailycode.springtutorial.model.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> getAllDepartment();

    public Optional<Department> getDepartmentById(Long departmentId);

    public void deleteDepartmentById(Long departmentId);
}
