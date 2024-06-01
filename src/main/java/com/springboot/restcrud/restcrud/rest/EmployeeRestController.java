package com.springboot.restcrud.restcrud.rest;

import com.springboot.restcrud.restcrud.entity.Employee;
import com.springboot.restcrud.restcrud.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeID}")
    public void deleteEmployee(@PathVariable int employeeID){

        Employee theEmployee = employeeService.findById(employeeID);

        if(theEmployee == null){
            throw new RuntimeException("ID not found" + employeeID);
        }

        employeeService.deleteById(employeeID);
    }

}
