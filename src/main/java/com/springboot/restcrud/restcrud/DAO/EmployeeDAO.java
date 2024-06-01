package com.springboot.restcrud.restcrud.DAO;

import com.springboot.restcrud.restcrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

}
