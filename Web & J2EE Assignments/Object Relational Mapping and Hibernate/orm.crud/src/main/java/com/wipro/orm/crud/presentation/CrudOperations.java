package com.wipro.orm.crud.presentation;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.wipro.orm.crud.dao.HibernateUtil;
import com.wipro.orm.crud.entity.Employee;

public class CrudOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();

		Employee emp = new Employee(102, "Vishal", 30000);
		Employee emp1 = new Employee(103, "Aravind", 40000);
		session.save(emp1);

		session.save(emp);
//		 update operation

//		Employee emp = session.get(Employee.class, 102);
//		Employee e=new Employee(102, "Vishal", 50000);
//		session.save(e);

		System.out.println(emp + "inserted");
		System.out.println(emp1 + "inserted");

//		 emp.setEname("Vikas Ankam"); emp.setSalary(75000);

//		 session.saveOrUpdate(emp); 
//		 Serializable ser = session.save(emp); 
		// insert or update

//		 System.out.println(ser.toString() +" employee record affected..");

		// delete operation

//		session.delete(emp);
//
//		System.out.println(ser.toString()+" record deleted successfully...");

		tr.commit();

	}

}
