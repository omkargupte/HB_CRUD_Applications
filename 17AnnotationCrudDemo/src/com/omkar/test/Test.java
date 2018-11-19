package com.omkar.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.omkar.dao.EmployeeDao;
import com.omkar.dao.EmployeeDaoFactory;

import com.omkar.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		int choice, eno = 0;
		String ename = null, eaddr = null, status = " ";
		float esal = 0.0f;
		EmployeeDao dao = EmployeeDaoFactory.getInstance();
		try {
			while (true) {
				@SuppressWarnings("resource")
				Scanner s = new Scanner(System.in);
				System.out.println("**** MENU ****");
				System.out.println();
				System.out.println("1. Add Employee");
				System.out.println("2. Search Employee");
				System.out.println("3. Update Employee");
				System.out.println("4. Delete Employee");
				System.out.println("5. Display All Records");
				System.out.println("6. Display Maximum Salary Employee");
				System.out.println("7. Display Minimum Salary Employee");
				System.out.println("8. Exit");
				System.out.println();
				System.out.println("-----------------------------");
				System.out.println("Please Enter Your Choice:");
				choice = s.nextInt();

				switch (choice) {
				case 1:

					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					System.out.println("--------------------------");
					System.out.println("Enter number:");
					eno = Integer.parseInt(br.readLine());
					System.out.println("Enter name:");
					ename = br.readLine();
					System.out.println("Enter salary:");
					esal = Float.parseFloat(br.readLine());
					System.out.println("Enter address:");
					eaddr = br.readLine();
					Employee emp = new Employee();
					emp.setEno(eno);
					emp.setEname(ename);
					emp.setEsal(esal);
					emp.setEaddr(eaddr);
					status = dao.addEmployee(emp);
					if (status.equals("success"))
						System.out.println("*****Record Added Successfully...!!!!");
					else if (status.equals("existed"))
						System.out.println("Record Already Existed..");
					else if (status.equals("failure"))
						System.out.println("Failed to add.");
					break;
					
				case 2:BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("--------------------------");
				System.out.println("Enter number:");
				eno = Integer.parseInt(br1.readLine());
				emp=dao.searchEmployee(eno);
				if(emp==null)
				{
					System.out.println("Record Does Not Exist...");
				}
				else
				{
					System.out.println("** Your Details **");
					System.out.println("------------------------------");
					System.out.println("Employee Number: "+ emp.getEno());
					System.out.println("Employee Name: "+ emp.getEname());
					System.out.println("Employee Salary: "+ emp.getEsal());
					System.out.println("Employee Address: "+ emp.getEaddr());
					System.out.println("------------------------------");
				}
				break;
				case 3:BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("--------------------------");
				System.out.println("Enter number:");
				eno = Integer.parseInt(br2.readLine());
				emp=dao.searchEmployee(eno);
				if(emp==null)
				{
					System.out.println("Record Does Not Exist...");
				}
				else
				{
					System.out.println("** Your Details For Updation **");
					System.out.println("------------------------------");
					System.out.println("Employee Number: "+ emp.getEno());
					System.out.println("Employee Name: "+ emp.getEname()+ " New Name:");
					String newEname=br2.readLine();
					System.out.println("Employee Salary: "+ emp.getEsal()+ " New Salary:");
					String newEsal=br2.readLine();
					System.out.println("Employee Address: "+ emp.getEaddr()+ " New Address");
					String newEaddr=br2.readLine();
					System.out.println("------------------------------");
					Employee newEmp=new Employee();
					newEmp.setEno(eno);
					if(newEname==null || newEname.equals(""))
					{
						newEmp.setEname(emp.getEname());
					}
					else
					{
						newEmp.setEname(newEname);
					}
					if(newEsal==null || newEsal.equals(""))
					{
						newEmp.setEsal(emp.getEsal());
					}
					else
					{
						newEmp.setEsal(Float.parseFloat(newEsal));
					}
					if(newEaddr==null || newEaddr.equals(""))
					{
						newEmp.setEaddr(emp.getEaddr());
					}
					else
					{
						newEmp.setEaddr(newEaddr);
					}
					status=dao.updateEmployee(newEmp);
					if (status.equals("success"))
						System.out.println("*****Record Updated Successfully...!!!!");
					else if (status.equals("failure"))
						System.out.println("Failed to add.");
				}
				break;
				
				case 4:BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("--------------------------");
				System.out.println("Enter number:");
				eno = Integer.parseInt(br3.readLine());
				emp=dao.searchEmployee(eno);
				if(emp==null)
				{
					System.out.println("Record Does Not Exists..");
				}
				else
				{
					status=dao.deleteEmployee(eno);
					if(status.equals("success"))
					System.out.println("Record Deleted successfully..");
					else if (status.equals("failure"))
						System.out.println("Failed to add.");
				}
				break;
				case 5:	@SuppressWarnings("unchecked") 
						List<Employee> list=dao.displayAllRecords();
						System.out.println("** The Detials Of Employees Are: **");
						System.out.println("--------------------------------------");
						System.out.println(list);
						break;
				case 6:emp=dao.MaxiSalRecord();
						System.out.println();
						System.out.println("** Employee With Maximum Salary **");
						System.out.println(emp);
						System.out.println();
						break;
				case 7:	emp=dao.MiniSalRecord();
						System.out.println();
						System.out.println("** Employee With Maximum Salary **");
						System.out.println(emp);
						System.out.println();
						break;
				case 8:System.exit(0);
						break;
				default:System.out.println("Invalid choice....");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
