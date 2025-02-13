package com.brique.test.domain;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class EmployeeWithDepartmentDTO {
    private int emp_no;
    private String first_name;
    private String last_name;
    private String gender;
    private Date hire_date;
    private String dept_name;
    private String title;
    private int max_salary;


}
