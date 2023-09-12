package com.dailycodebuffer.employeeservice.service;

import com.dailycodebuffer.employeeservice.entity.Employee;
import com.dailycodebuffer.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Long id) {
        Optional<Employee> employeeOptional =  employeeRepository.findById(id);
        return employeeOptional.orElse(null);
    }

    @Override
    public List<Employee> getEmployeesByDeptId(Long id) {
        return employeeRepository.findByDepartmentId(id);
    }

}
