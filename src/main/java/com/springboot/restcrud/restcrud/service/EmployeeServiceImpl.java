package com.springboot.restcrud.restcrud.service;

import com.springboot.restcrud.restcrud.DAO.EmployeeDAO;
import com.springboot.restcrud.restcrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {

        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theID) {
        return employeeDAO.findById(theID);
    }
}
