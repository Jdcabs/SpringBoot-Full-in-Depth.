package com.dailycode.springtutorial.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    @Column(length = 100, nullable = false)
    @NotBlank(message = "Please Add Department Name")
    private String departmentName;
    
    @Column(length = 150, nullable = false)
    private String departmentAddress;
    
    @Column(length = 100, nullable = false)
    private String departmentCode;

    public Department(Long departmentId, String departmentName, String departmentAddress, String departmentCode) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
        this.departmentCode = departmentCode;
    }

    public Department() {}

    public Long getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentAddress='" + departmentAddress + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(getDepartmentId(), that.getDepartmentId())
                && Objects.equals(getDepartmentName(), that.getDepartmentName())
                && Objects.equals(getDepartmentAddress(), that.getDepartmentAddress())
                && Objects.equals(getDepartmentCode(), that.getDepartmentCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDepartmentId(), getDepartmentName(), getDepartmentAddress(), getDepartmentCode());
    }
}
