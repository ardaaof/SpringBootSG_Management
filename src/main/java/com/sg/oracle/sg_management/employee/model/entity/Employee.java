package com.sg.oracle.sg_management.employee.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "EMPLOYEES")
//@SequenceGenerator(name="EMPLOYEE_ID_SEQ",sequenceName = "EMPLOYEE_ID_SEQ",initialValue = 1,allocationSize = 1)
@Entity
public class Employee {

   // @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "EMPLOYEE_ID_SEQ")
    @Column(name = "TCKN")
    @Id
    private String TCKN;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    private double salary;

    @Temporal(TemporalType.DATE)
    @Column(name = "HIRE_DATE")
    private Date hireDate;

    public Employee(String TCKN,String firstName, String lastName, double salary) {
        this.TCKN=TCKN;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public Employee() {
    }
}
