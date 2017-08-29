package com.emids.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.emids.EmployeeBean.EmployeeBean;
import com.emids.EmployeeService.EmployeeService;
import com.emids.springModel.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("command")EmployeeBean employeeBean, 
			   BindingResult result) {
			  Employee employee = prepareModel(employeeBean);
			  employeeService.addEmployee(employee);
			  return new ModelAndView("redirect:/add.html");
			 }
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployee(@ModelAttribute("command")  EmployeeBean employeeBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("addEmployee", model);
	}
	 private Employee prepareModel(EmployeeBean employeeBean){
		  Employee employee = new Employee();
		  employee.setEmpAddress(employeeBean.getAddress());
		  employee.setEmpAge(employeeBean.getAge());
		  employee.setEmpName(employeeBean.getName());
		  employee.setSalary(employeeBean.getSalary());
		  employee.setEmpId(employeeBean.getId());
		  employeeBean.setId(null);
		  return employee;
		 }
}
