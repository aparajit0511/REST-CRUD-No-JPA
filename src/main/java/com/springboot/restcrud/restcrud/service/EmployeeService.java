package com.springboot.restcrud.restcrud.service;

import com.springboot.restcrud.restcrud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theID);

    Employee save(Employee theEmployee);
}
