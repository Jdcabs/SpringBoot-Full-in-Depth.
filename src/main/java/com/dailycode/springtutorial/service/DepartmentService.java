package com.dailycode.springtutorial.service;

import com.dailycode.springtutorial.model.Department;
import com.dailycode.springtutorial.model.SecondDepartment;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getAllDepartment();

    Optional<Department> getDepartmentById(Long departmentId);

    void deleteDepartmentById(Long departmentId);

    Department updateDepartmentById(Long departmentId, Department department);

    Department getDepartmentByDepartmentName(String departmentName);
}
