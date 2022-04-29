package com.example.demo.com.sql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.example.demo.Employee;



public class SQLExample {
	
	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration().configure().buildSessionFactory();
		
		Session s= factory.openSession();
		//psql query
		String q= "select * from employee";
		
		NativeQuery nq=  s.createSQLQuery(q);
		
		List<Employee> list= nq.list();
		for(Employee employee:list)
		{
			System.out.println(employee.getName()+" : "+employee.getCity());
		}
		
		s.close();
		factory.close();
	}

}
