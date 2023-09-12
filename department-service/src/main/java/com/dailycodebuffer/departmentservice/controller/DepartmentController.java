package com.dailycodebuffer.departmentservice.controller;

import com.dailycodebuffer.departmentservice.client.EmployeeClient;
import com.dailycodebuffer.departmentservice.entity.Department;
import com.dailycodebuffer.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping("/")
    public Department addDepartment(@RequestBody Department department) {
        log.info("addDepartment: Department adding request : {}", department.toString());
        return departmentService.addDepartment(department);
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable("id") Long id) {
        log.info("getDepartment: Department search request : {}", id);
        return departmentService.findDepartmentById(id);
    }

    @GetMapping("/")
    public List<Department> getAllDepartments() {
        log.info("getAllDepartments : getting all departments");
        return departmentService.getAllDepartments();
    }

    @GetMapping("/with-employees")
    public List<Department> getAllDepartmentsWithEmployees() {
        log.info("getAllDepartmentsWithEmployees : getting all departments");
        return departmentService.getAllDepartmentsWithEmployees();
    }
}
