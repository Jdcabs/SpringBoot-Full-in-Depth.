package com.dailycode.springtutorial.service;

import com.dailycode.springtutorial.model.Department;
import com.dailycode.springtutorial.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId);
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) {

        Department depDb = departmentRepository.findById(departmentId).get();

        if(!depDb.getDepartmentName().isEmpty()
                && !depDb.getDepartmentName().isBlank()
                && Objects.nonNull(depDb.getDepartmentName())) {
            depDb.setDepartmentName(department.getDepartmentName());
        }
        if(!depDb.getDepartmentCode().isEmpty()
                && !depDb.getDepartmentCode().isBlank()
                && Objects.nonNull(depDb.getDepartmentCode())) {
            depDb.setDepartmentCode(department.getDepartmentCode());
        }
        if(!depDb.getDepartmentAddress().isEmpty()
                && !depDb.getDepartmentAddress().isBlank()
                && Objects.nonNull(depDb.getDepartmentAddress())) {
            depDb.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(depDb);
    }

    @Override
    public Department getDepartmentByDepartmentName(String departmentName) {
        return (departmentRepository.findByDepartmentNameIgnoreCase(departmentName).isPresent())
                ? departmentRepository.findByDepartmentNameIgnoreCase(departmentName).get()
                : departmentRepository.findByDepartmentNameIgnoreCase(departmentName).orElseThrow(() -> new RuntimeException("Cannot FInd this department"));
    }
}
