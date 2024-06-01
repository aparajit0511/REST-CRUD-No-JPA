package com.springboot.restcrud.restcrud.DAO;

import com.springboot.restcrud.restcrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }


    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        List<Employee> employeeList = theQuery.getResultList();

        return employeeList;
    }

    @Override
    public Employee findById(int theID) {

        Employee theEmployee = entityManager.find(Employee.class,theID);

        return theEmployee;

    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge(theEmployee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int theID) {

        Employee deleteEmployee = entityManager.find(Employee.class,theID);

        entityManager.remove(deleteEmployee);

    }
}
