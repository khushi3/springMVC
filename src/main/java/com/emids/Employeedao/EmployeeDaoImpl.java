package com.emids.Employeedao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emids.springModel.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

 @Autowired
 private SessionFactory sessionFactory;
 
 public void addEmployee(Employee employee) {
   sessionFactory.getCurrentSession().saveOrUpdate(employee);
 }


}


