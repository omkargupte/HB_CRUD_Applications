package com.omkar.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.omkar.pojo.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	Employee emp=null;
	String status=" ";
	@Override
	public String addEmployee(Employee employee) {
		try {
			Configuration cfg=new Configuration();
			cfg.configure();
			SessionFactory sf=cfg.buildSessionFactory();
			Session session=sf.openSession();
			Transaction tx=session.beginTransaction();
			
			emp=(Employee)session.get(Employee.class, employee.getEno());/*To add a new record firstly check whether DB contains same record or not*/
			if(emp==null)
			{
				session.save(employee);
				tx.commit();
				status="success";
			}
			else
			{
				status="existed";
			}
			session.close();
			sf.close();
		} catch (Exception e) {
			status="failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Employee searchEmployee(int eno) {
		try {
			Configuration cfg=new Configuration();
			cfg.configure();
			SessionFactory sf=cfg.buildSessionFactory();
			Session session=sf.openSession();
			emp=session.get(Employee.class, eno);
			session.close();
			sf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public String updateEmployee(Employee employee) {
		try {
			Configuration cfg=new Configuration();
			cfg.configure();
			SessionFactory sf=cfg.buildSessionFactory();
			Session session=sf.openSession();
			Transaction tx=session.beginTransaction();
			session.update(employee);
			tx.commit();
			status="success";
			session.close();
			sf.close();
		} catch (Exception e) {
			status="failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String deleteEmployee(int eno) {
		try {
			Configuration cfg=new Configuration();
			cfg.configure();
			SessionFactory sf=cfg.buildSessionFactory();
			Session session=sf.openSession();
			Transaction tx=session.beginTransaction();
			emp.setEno(eno);
			session.delete(emp);
			tx.commit();
			status="success";
			session.close();
			sf.close();
		} catch (Exception e) {
			status="failure";
			e.printStackTrace();
		}
		return status;
	}

}
