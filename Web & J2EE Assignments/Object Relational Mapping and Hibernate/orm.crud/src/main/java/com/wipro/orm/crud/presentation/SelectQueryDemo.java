package com.wipro.orm.crud.presentation;

import java.util.List;

import com.wipro.orm.crud.dao.EmployeeDao;
import com.wipro.orm.crud.entity.Employee;

public class SelectQueryDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
//		EmployeeDao dao = new EmployeeDao();
		EmployeeDao dao= new EmployeeDao();
		
		//HQL Query
		System.out.println("this is HQL Query Execution");
		List<Employee> list1 = dao.getAllEmployees();
	
		list1.forEach((emp)->{System.out.println(emp);});
		
		
		
		
		System.out.println("this is native SQL Query execution");
		Employee e = dao.getEmployeeSQL();
		System.out.println(e);
		
		
		System.out.println("this is named query execution");
		List<Employee> list2= dao.getAllEmployeeDetailsNq();
		list2.forEach((emp1)->{System.out.println(emp1);});
		
		dao.getSalaries().forEach((salary)->{System.out.println(salary);});
	
	}

}
