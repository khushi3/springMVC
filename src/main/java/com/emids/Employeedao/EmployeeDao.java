package com.emids.Employeedao;

import java.util.List;

import com.emids.springModel.Employee;

public interface EmployeeDao {

	public void addEmployee(Employee employee);
	public List<Employee> listEmployeess();
	
	public Employee getEmployee(int empid);
}
