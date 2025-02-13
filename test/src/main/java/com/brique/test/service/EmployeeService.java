package com.brique.test.service;

import com.brique.test.domain.Employee;
import com.brique.test.domain.EmployeeWithDepartmentDTO;
import com.brique.test.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;





    public List<EmployeeWithDepartmentDTO> getMaxSalaryEmployees() {

        System.out.println("service");


        return employeeMapper.getMaxSalaryEmployees();
    }

}
