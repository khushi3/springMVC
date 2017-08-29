package com.emids.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.emids.Employeedao.EmployeeDao;
import com.emids.springModel.Employee;

@Service("employeeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

 @Autowired
 private EmployeeDao employeeDao;
 
 @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
 public void addEmployee(Employee employee) {
  employeeDao.addEmployee(employee);
 }
}
