package com.brique.test.mapper;

import com.brique.test.domain.Employee;
import com.brique.test.domain.EmployeeWithDepartmentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    // 2000년 이후 고용된 직원과 최대 급여 조회
    List<EmployeeWithDepartmentDTO> getMaxSalaryEmployees();
}
