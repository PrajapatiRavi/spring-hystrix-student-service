package com.springhystrixstudentservice.springhystrixstudentservice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springhystrixstudentservice.springhystrixstudentservice.beans.Employee;
import com.springhystrixstudentservice.springhystrixstudentservice.beans.Student;

@RestController
public class EmployeeServiceController {

	private static Map<String, List<Employee>> employeeDB = new HashMap<String, List<Employee>>();

	static {
		employeeDB = new HashMap<String, List<Employee>>();

		List<Employee> lst = new ArrayList<Employee>();
		Employee emp = new Employee(101, "Ravi", "rprajapati067@gmail.com", "Bhopal");
		lst.add(emp);
		emp = new Employee(102, "Kavya", "9876785678", "kavyashree.pv@capgemini.com");
		lst.add(emp);
		emp = new Employee(103, "Vijya", "9876785897", "vijya@capgemini.com");
		lst.add(emp);

		employeeDB.put("capgemini", lst);

	}

	@RequestMapping(value = "/getEmployeeDetails/{companyName}", method = RequestMethod.GET)
	public List<Employee> getEmployeeDetails(@PathVariable String companyName) {
		System.out.println("Getting Student details for " + companyName);

		List<Employee> employeeList = employeeDB.get(companyName);
		if (employeeList == null) {
			employeeList = new ArrayList<Employee>();
			Employee std = new Employee(0, "Name Not found", "Phone Not Found", "Email Not Found");
			employeeList.add(std);
		}
		return employeeList;
	}
}
