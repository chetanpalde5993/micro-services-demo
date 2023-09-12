package com.dailycodebuffer.employeeservice.service;

import com.dailycodebuffer.employeeservice.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    Employee getEmployee(Long id);

    List<Employee> getEmployeesByDeptId(Long id);
}
