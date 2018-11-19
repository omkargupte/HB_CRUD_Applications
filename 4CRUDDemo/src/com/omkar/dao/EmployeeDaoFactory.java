package com.omkar.dao;

public class EmployeeDaoFactory {
	public static EmployeeDao getInstance()
	{
		return new EmployeeDaoImpl();
	}

}
