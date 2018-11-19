package com.omkar.dao;

import com.omkar.pojo.Employee;

public interface EmployeeDao {
	public abstract String addEmployee(Employee employee);
	public abstract Employee searchEmployee(int eno);
	public abstract String updateEmployee(Employee employee);
	public abstract String deleteEmployee(int eno);
}
