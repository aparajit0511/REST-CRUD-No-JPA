package com.springboot.restcrud.restcrud.rest;

import com.springboot.restcrud.restcrud.entity.Employee;
import com.springboot.restcrud.restcrud.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeID}")
    public Employee findById(@PathVariable int employeeID){
        Employee theEmployee = employeeService.findById(employeeID);

        if(theEmployee == null){
            throw new RuntimeException("ID not found" + employeeID);
        }

        return theEmployee;
    }

}
