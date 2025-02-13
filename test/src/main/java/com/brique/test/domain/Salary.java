package com.brique.test.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class Salary {
    private int emp_no;
    private int salary;
    private Date from_date;
    private Date to_date;


}
