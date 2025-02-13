package com.brique.test.controller;

import com.brique.test.domain.Employee;
import com.brique.test.domain.EmployeeWithDepartmentDTO;
import com.brique.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/max-salary")
    public List<EmployeeWithDepartmentDTO> getMaxSalaryEmployees() {

        System.out.println("controller");

        return employeeService.getMaxSalaryEmployees();
    }
}
