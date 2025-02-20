package com.wipro.orm.crud.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import com.wipro.orm.crud.entity.Employee;

public class EmployeeDao {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	Session session = sessionFactory.openSession();

	// HQL
	public List<Employee> getAllEmployees() {

//		String hqlQuery = "select e from Employee e";
		String hqlQuery = "select e from Employee e where e.salary>?1 order by e.ename";
		Query query = session.createQuery(hqlQuery);
		query.setParameter(1, 25000.00);
		List<Employee> list = query.getResultList();

		return list;
	}

	// NativeSQLQuery
	public Employee getEmployeeSQL() {

		String sqlQuery = "select * from Employee_Info where eid=?1";

		// session.createSQLQuery(sqlQuery);

		NativeQuery<Employee> nativeQuery = session.createNativeQuery(sqlQuery, Employee.class);

		nativeQuery.setParameter(1, 101);

		Employee emp = nativeQuery.getSingleResult();

		return emp;

	}

	
	
	
	public List<Employee> getAllEmployeeDetailsNq() {
		Query<Employee> query= session.getNamedSQLQuery("getAllEmployeeDetailsNq");
		
		List<Employee> list= query.getResultList();
		
		
		
		return list;
		
		
	}
	
	public List<Double> getSalaries(){
		
		Query<Double> query = session.getNamedSQLQuery("getSalaries");
		
		List<Double> list= query.getResultList();
		return list;
		
	}
}
