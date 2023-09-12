package com.dailycodebuffer.departmentservice.service;

import com.dailycodebuffer.departmentservice.client.EmployeeClient;
import com.dailycodebuffer.departmentservice.entity.Department;
import com.dailycodebuffer.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department addDepartment(Department department) {
        log.info("addDepartment : saving department");
        return departmentRepository.save(department);
    }

    @Override
    public Department findDepartmentById(Long id) {
        log.info("findDepartmentById : finding department");
        return departmentRepository.findByDepartmentId(id);
    }

    @Override
    public List<Department> getAllDepartments() {
        log.info("getAllDepartments: Getting all departments");
        return departmentRepository.findAll();
    }
    @Autowired
    private EmployeeClient employeeClient;

    @Override
    public List<Department> getAllDepartmentsWithEmployees() {
        List<Department> departments = departmentRepository.findAll();
        for(Department department : departments) {
            log.info("-->{}",employeeClient.findEmployeesByDepartmentId(department.getDepartmentId()));
        }
        departments.forEach(department -> {
            department.setEmployees(
                employeeClient.findEmployeesByDepartmentId(
                        department.getDepartmentId()
                )
            );
        });
        return departments;
    }
}
