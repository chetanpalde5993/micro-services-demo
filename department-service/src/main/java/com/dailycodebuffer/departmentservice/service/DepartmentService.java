package com.dailycodebuffer.departmentservice.service;

import com.dailycodebuffer.departmentservice.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department addDepartment(Department department);

    Department findDepartmentById(Long id);

    List<Department> getAllDepartments();

    List<Department> getAllDepartmentsWithEmployees();
}
