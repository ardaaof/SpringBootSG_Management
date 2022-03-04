package com.sg.oracle.sg_management.employee.controller;

import com.sg.oracle.sg_management.employee.model.entity.Employee;
import com.sg.oracle.sg_management.employee.model.repository.EmployeeRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.util.List;

@Setter
@Getter
@ViewScoped
@Named
public class EmployeeManagedBean {

    @Autowired
    private EmployeeRepository employeeRepository;

    private String infoMessage;

    private String inputTCKN;
    private String inputFirstName;
    private String inputLastName;
    private String inputSalary;


    public void delete()
    {
        try
        {
            employeeRepository.deleteById(inputTCKN);
            infoMessage="Silme Basarili";
            //deneme
        }
        catch (NumberFormatException e)
        {
            infoMessage= com.sg.oracle.sg_management.utility.Util.createGeneralException(e);
        }

    }


    public void insert()
    {
        try {
            Employee employee=new Employee(inputTCKN,inputFirstName,inputLastName,Double.parseDouble(inputSalary));
            Employee savedEmployee=employeeRepository.save(employee);
            infoMessage=savedEmployee.getTCKN() != null ? "Ekleme Basarili":"Ekleme Basarisiz";
        }
        catch (IllegalArgumentException e)
        {
            infoMessage= com.sg.oracle.sg_management.utility.Util.createGeneralException(e);
        }


    }

    public List<Employee> getEmployeeList()
    {
        return employeeRepository.findAll();
    }
}
