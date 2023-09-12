package com.dailycodebuffer.departmentservice.client;

import com.dailycodebuffer.departmentservice.entity.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange //Looks same as feign client but feing more developer friendly
                //We need webclient
                // Need to add dependencies for reactive web dependencies
@Component
//@FeignClient("employee-service") //This is from netflix-core package
public interface EmployeeClient {
    @GetExchange("/employees/department/{departmentId}")
//    @GetMapping("/employees/department/{departmentId}")
    public List<Employee> findEmployeesByDepartmentId(@PathVariable("departmentId") Long id);
}
