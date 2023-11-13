package com.dailycode.springtutorial.repository;

import com.dailycode.springtutorial.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    @Query("select d from Department d where upper(d.departmentName) like upper(concat('%', ?1, '%'))")
    Optional<Department> FindByDepartmentName(@NonNull String departmentName);

}
