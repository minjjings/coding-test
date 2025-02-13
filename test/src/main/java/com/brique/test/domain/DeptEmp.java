package com.brique.test.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class DeptEmp {
    private int emp_no;
    private String dept_no;
    private Date from_date;
    private Date to_date;


}
