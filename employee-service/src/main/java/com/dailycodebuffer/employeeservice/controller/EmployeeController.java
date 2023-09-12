package com.dailycodebuffer.employeeservice.controller;

import com.dailycodebuffer.employeeservice.entity.Employee;
import com.dailycodebuffer.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee searchEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findEmployeesByDepartmentId(@PathVariable("departmentId") Long id) {
        return employeeService.getEmployeesByDeptId(id);
    }
}
