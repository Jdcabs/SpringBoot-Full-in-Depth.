package com.dailycode.springtutorial.service;

import java.util.List;
import java.util.Optional;

import com.dailycode.springtutorial.Exception.DepartmentNotFoundException;
import com.dailycode.springtutorial.model.Department;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getAllDepartment() throws DepartmentNotFoundException;

   Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartmentById(Long departmentId, Department department);

    Department getDepartmentByDepartmentName(String departmentName);
}
