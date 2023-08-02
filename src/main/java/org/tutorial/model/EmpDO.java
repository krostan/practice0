package org.tutorial.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class EmpDO implements Serializable {
    private Integer empno;
    private String ename;
    private String job;
    private LocalDate hiredate;
    private Double sal;
    private Double comm;
    private Integer deptno;

}
