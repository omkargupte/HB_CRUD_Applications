package com.omkar.dao;

import java.util.List;

import com.omkar.pojo.Employee;

public interface EmployeeDao {
	public abstract String addEmployee(Employee employee);
	public abstract Employee searchEmployee(int eno);
	public abstract String updateEmployee(Employee employee);
	public abstract String deleteEmployee(int eno);
	@SuppressWarnings("rawtypes")
	public abstract List displayAllRecords();
	public abstract Employee MaxiSalRecord();
	public abstract Employee MiniSalRecord();
}
